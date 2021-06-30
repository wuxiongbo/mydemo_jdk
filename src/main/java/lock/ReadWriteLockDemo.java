package lock;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/21
 * </pre>
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {

//        MyCache myCache = new MyCache();

        MyCacheCuncurrent myCache = new MyCacheCuncurrent();


        // 线程操作资源类，5个线程写
        for (int i = 0; i < 5; i++) {
            // lambda表达式内部必须是final
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt +  "");
            }, String.valueOf(i)).start();
        }

        // 线程操作资源类， 5个线程读
        for (int i = 0; i < 5; i++) {
            // lambda表达式内部必须是final
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }

    }



}
