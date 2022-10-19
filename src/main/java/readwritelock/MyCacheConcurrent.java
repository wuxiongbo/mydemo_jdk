package readwritelock;

/**
 * 读写锁
 * 多个线程 同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行
 * 但是，如果一个线程想去写共享资源，就不应该再有其它线程可以对该资源进行读或写
 *
 * @author: 陌溪
 * @create: 2020-03-15-16:59
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 资源类
 */
class MyCacheConcurrent {

    private static final Map<String, Object> MAP = new HashMap<>();

    /**
     * 创建一个 "读写锁"
     * 它是一个读写融为一体的锁，在使用的时候，需要转换
     */
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     * 定义 写操作
     * 满足：原子 + 独占
     * @param key
     * @param value
     */
    public void put(String key, Object value) {

        // 创建一个写锁
        rwLock.writeLock().lock();

        try {

            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);

            try {
                // 模拟网络拥堵，延迟0.3秒
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            MAP.put(key, value);

            System.out.println(Thread.currentThread().getName() + "\t 写入完成");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // 写锁 释放
            rwLock.writeLock().unlock();

        }
    }

    /**
     * 定义 读操作
     *
     * @param key
     */
    public void get(String key) {

        // 读锁
        rwLock.readLock().lock();

        try {

            System.out.println(Thread.currentThread().getName() + "\t 正在读取:");

            try {
                // 模拟网络拥堵，延迟0.3秒
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Object value = MAP.get(key);

            System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + value);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // 读锁释放
            rwLock.readLock().unlock();

        }
    }

    /**
     * 清空缓存
     */
    public void clean() {
        MAP.clear();
    }


}

