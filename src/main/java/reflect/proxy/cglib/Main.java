package reflect.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * <p> CGLib 方法拦截 MethodInterceptor </p>
 *  https://www.iteye.com/blog/shensy-1873155
 *
 *
 *  Cglib动态代理实现方式
 *  https://www.cnblogs.com/monkey0307/p/8328821.html
 *
 *  CGLIB的使用
 *  https://blog.csdn.net/weixin_40516305/article/details/106799948
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
public class Main {

    public static void main(String[] args){

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");

        // 这里Enhancer类是CGLib中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展，以后会经常看到它。
        Enhancer enhancer = new Enhancer();

        // 将被代理类ConcreteClassNoInterface设置成父类，
        enhancer.setSuperclass(ConcreteClassNoInterface.class);

        // 设置拦截器ConcreteClassInterceptor
        enhancer.setCallback(new ConcreteClassInterceptor());

        // 执行enhancer.create()动态生成一个代理类，
        Object obj = enhancer.create();
        // 将 Object 强制向下转型成  代理类的父类型ConcreteClassNoInterface。
        ConcreteClassNoInterface ccni = (ConcreteClassNoInterface)obj;


        System.out.println("=======================");

        // 在 代理类 上调用方法
        ccni.getConcreteMethodA("shensy");
//        ccni.getConcreteMethodB(0);

    }
}
