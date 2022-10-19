package temp;

/**
 * @author joonwhee
 * @date 2019/7/6
 */
public class VolatileTest {

    public static volatile int race = 0;

    private static final int THREADS_COUNT = 20;

    public static void increase() {
        race ++;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(mainGroup,() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    increase();
                }
            });
            threads[i].start();
        }


//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
        System.out.println(race);
    }
}