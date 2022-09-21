package jdk_proxy.dynamic_proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理, 动态代理类不要显示的实现被代理类所实现的接口
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */

public class MyInvocationHandler implements InvocationHandler {

    // 保存被代理实例
    private final Object object;

    public MyInvocationHandler(Object object){
        this.object = object;
    }

    // 关键是这个回调方法。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        System.out.println("MyInvocationHandler invoke begin");

        // 打印 invoke 入参
        System.out.println("proxy: "+ proxy.getClass().getName());
        System.out.println("method: "+ method.getName());
        for(Object o : args){
            System.out.println("arg: "+ o);
        }



        //通过反射调用 被代理类的原始方法。
        // $Proxy0 extends Proxy implements Person ;  object 就是这个 $Proxy0
        // method 是接口的方法
        // args 是 method 的方法参数
        method.invoke(object, args);




        System.out.println("MyInvocationHandler invoke end");

        return new Object();
    }




}
