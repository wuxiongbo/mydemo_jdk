package temp;


import java.lang.ref.WeakReference;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2022/4/21
 * </pre>
 */
public class ThreadLocaldemo {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void main(String[] args){

        test3();


    }


    // 与root 有强关系。即使被 WeakReference 包装，也不会GC回收
    public static void test1(){
        System.out.println(threadLocal);

        threadLocal.set(2131312L);

        WeakReference<ThreadLocal<Long>> a = new WeakReference <>(threadLocal);


        System.out.println(a.get());

        threadLocal=null;

        System.gc();

        System.out.println(a.get());

        Thread thread = Thread.currentThread();
    }


    // 断开与root 的强引用关系。ThreadLocal 会被GC回收。
    //如果这里不采用WeakReference，即使local=null，那么也不会回收Entry的key，因为Entry和key是强关联
    //但是，这里仅能做到回收key，不能回收value，如果这个线程运行时间非常长，即使referent GC了，value持续不清空，就有内存溢出的风险
    //彻底回收最好调用remove。
    //即：local.remove();
    // remove相当于把ThreadLocalMap里的这个元素干掉了，并没有把自己干掉
    public static void test2(){
        System.out.println(threadLocal);

        threadLocal.set(111L);

        threadLocal=null;

        System.gc();

        Thread thread = Thread.currentThread();
    }

    public static void test2_1(){
        System.out.println(threadLocal);

        threadLocal.set(111L);

        Thread thread = Thread.currentThread();


        threadLocal.remove();
        thread = Thread.currentThread();
    }



    // 会被GC回收的是， WeakReference 内的元素，不是 WeakReference 实例自身。
    public static void test3(){

        WeakReference<Object> a = new WeakReference <>(new Object());

        System.out.println(a.get());
        System.out.println(a);

        System.gc();

        System.out.println(a.get());
        System.out.println(a);
    }

}
