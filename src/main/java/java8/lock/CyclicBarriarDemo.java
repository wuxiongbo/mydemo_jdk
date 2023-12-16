package java8.lock;

import cn.hutool.core.thread.NamedThreadFactory;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author Xander Wu
 * @date 2023/12/12 16:04
 */
public class CyclicBarriarDemo {
    private static final Integer THREAD_SIZE = 3;
    private static final ThreadPoolExecutor pool = new ThreadPoolExecutor(
            THREAD_SIZE, THREAD_SIZE, 0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), new NamedThreadFactory("pool1-", true));

    public static void main(String[] args) throws Exception {

        ArrayList<CompletableFuture<Integer>> completableFutures = new ArrayList<>();
        for (int start = 1, end = 100, i = 0; i < 3; i++, start += 100, end += 100) {
            int finalStart = start;
            int finalEnd = end;
            completableFutures.add(CompletableFuture.supplyAsync(() -> sum(finalStart, finalEnd), pool));
        }
        // 1 ~ 100
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();

        int sum = 0;
        for (CompletableFuture<Integer> future : completableFutures) {
            sum += future.get();
        }
        System.out.println("sum:" + sum);

        Thread.sleep(10000L);
        pool.shutdown();
    }


    private static Integer sum(Integer start, Integer end) {
        Integer sum1 = 0;
        try {
            for (int i = start; i <= end; i++) {
                sum1 = sum1 + i;
            }
        } catch (Exception e) {
            System.out.println("1 error:" + e.getMessage());
        }
        System.out.println(sum1);
        System.out.println(Thread.currentThread().getName());
        return sum1;
    }


}