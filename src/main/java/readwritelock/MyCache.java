package readwritelock;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 读写锁
 * 可  并发 '读'
 *       多个线程 同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行
 * 不可 并发 '写'
 *       但是，如果一个线程想去写共享资源，就不应该再有其它线程可以对该资源进行读或写
 */
class MyCache {

    private static final Map<String, Object> MAP = new HashMap<>();

    /**
     * 定义写操作
     * 满足：原子 + 独占
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
        try {
            // 模拟网络拥堵，延迟0.3秒
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MAP.put(key, value);
        System.out.println(Thread.currentThread().getName() + "\t 写入完成");
    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "\t 正在读取:");
        try {
            // 模拟网络拥堵，延迟0.3秒
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object value = MAP.get(key);
        System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + value);
    }


}


