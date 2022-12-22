package reflect.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 *
 *  Enhancer：
 *    Enhancer 既能够代理普通的class，也能够代理接口。
 *    Enhancer 可以创建一个被代理对象的子类，并且拦截所有的方法调用（包括从Object中继承的toString和hashCode方法）。
 *    Enhancer 不能够拦截 final 类 与 方法。
 *
 *
 *  Callback： 是一个空的接口，在Cglib中它的实现类有以下几种：
 *     MethodInterceptor
 *     InvocationHandler
 *     FixedValue          FixedValue，用来对所有拦截的方法返回相同的值
 *     NoOp
 *     LazyLoader
 *     Dispatcher
 *
 *  MethodInterceptor：
 *     它可以实现类似于AOP编程中的环绕增强（around-advice）。
 *
 *     它只有一个方法：
 *     public Object intercept(
 *            Object obj, java.lang.reflect.Method method, Object[] args, MethodProxy proxy)
 *
 *     代理类的所有方法调用都会转而执行这个接口中的intercept方法而不是原方法。
 *     如果需要在intercept方法中执行原方法  可以使用参数method进行反射调用，
 *     或者  使用参数  proxy 一 proxy.invokeSuper(obj, args);
 *     后者会快一些（反射调用比正常的方法调用的速度慢很多）。
 *     MethodInterceptor允许我们完全控制被拦截的方法，并且提供了手段对原方法进行调用，
 *     因为 MethodInterceptor的效率不高，它需要产生不同类型的字节码，
 *     并且需要生成一些运行时对象（InvocationHandler就不需要），所以Cglib提供了其它的接口供我们选择。
 *
 * InvocationHandler：
 *     它的使用方式和MethodInterceptor差不多。
 *     需要注意的一点是，所有对invoke()方法的参数proxy对象的方法调用都会被委托给同一个InvocationHandler，
 *     所以可能会导致无限循环。
 *
 *  CGLib 方法拦截 MethodInterceptor
 *  https://www.iteye.com/blog/shensy-1873155
 *  Cglib动态代理实现方式
 *  https://www.cnblogs.com/monkey0307/p/8328821.html
 *  CGLIB的使用
 *  https://blog.csdn.net/weixin_40516305/article/details/106799948
 *
 * 加vm参数：
 *
 * --add-opens java.base/java.lang=ALL-UNNAMED
 *
 *
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
public class Main {

    public static void main(String[] args){

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/10027088/Downloads/logs");

        ConcreteClassNoInterface origin = new ConcreteClassNoInterface();

        // 这里Enhancer类是CGLib中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展，以后会经常看到它。
        Enhancer enhancer = new Enhancer();

        // 将被代理类ConcreteClassNoInterface设置成父类，
        enhancer.setSuperclass(origin.getClass());

        // 设置 方法拦截器ConcreteClassInterceptor
        enhancer.setCallback(new ConcreteClassInterceptor(origin));
        // 设置 类拦截器
//        enhancer.setCallback(new ConcreteClassInvocationHandler());




        // 执行enhancer.create()动态生成一个代理类，并创建实例。
        // 代理类 实例 流程：
        // create -> createHelper -> super.create -> firstInstance -> createUsingReflection
        Object obj = enhancer.create();
        // 将 Object 强制向下转型成  代理类的父类型ConcreteClassNoInterface。
        ConcreteClassNoInterface proxy = (ConcreteClassNoInterface)obj;




        System.out.println("=======================");

        // 在 代理类 上调用方法
        proxy.getConcreteMethodA("shensy");
//        ccni.getConcreteMethodB(0);

//        ccni.test("11111");

    }
}
