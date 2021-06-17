package reflect.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
public class Main {

    public static void main(String[] args){
        // 这里Enhancer类是CGLib中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展，以后会经常看到它。
        Enhancer enhancer=new Enhancer();

        // 将被代理类ConcreteClassNoInterface设置成父类，
        enhancer.setSuperclass(ConcreteClassNoInterface.class);
        // 设置拦截器ConcreteClassInterceptor
        enhancer.setCallback(new ConcreteClassInterceptor());

        // 执行enhancer.create()动态生成一个代理类，并从Object强制转型成父类型ConcreteClassNoInterface。
        ConcreteClassNoInterface ccni=(ConcreteClassNoInterface)enhancer.create();

        // 在代理类上调用方法
        ccni.getConcreteMethodA("shensy");

        System.out.println("=======================");

        ccni.getConcreteMethodB(0);

    }
}
