package reflect.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p> MethodInterceptor 拦截器</p>
 *  在调用目标方法时，CGLib会回调MethodInterceptor接口方法拦截，来实现你自己的代理逻辑，类似于JDK中的InvocationHandler接口。
 *
 *  在本示例中，只在 调用 ‘被代理类’方法 前、后 各打印了一句话，当然实际编程中可以是其它复杂逻辑。
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
public class ConcreteClassInterceptor implements MethodInterceptor {
    /**
     * @param obj         由CGLib动态生成的代理类实例
     * @param method      上文中实体类所调用的被代理的方法引用
     * @param arg         参数值列表
     * @param proxy       生成的代理类对方法的代理引用
     * @return            从代理实例的方法调用返回的值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {
        System.out.println("Before:"+method);

        // 调用代理类实例上的proxy方法的父类方法（即实体类ConcreteClassNoInterface中对应的方法）
        Object object = proxy.invokeSuper(obj, arg);
        System.out.println("result:"+object);

        System.out.println("After:"+method);
        return object;
    }
}
