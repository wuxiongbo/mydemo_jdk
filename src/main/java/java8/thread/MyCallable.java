package java8.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 异步阻塞
 * @Author: Battle Bear
 * @Date: 2022/5/8 10:56
 * @Description:
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("MyCallable call");

        Thread.sleep(1000*10);

        return "success";
    }

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        try {
            // 事情交给小明做。
            Future<String> future = threadPool.submit(new MyCallable());

            // 傻傻的等待小明完成。
            System.out.println(future.get());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            threadPool.shutdown();
        }

    }

}