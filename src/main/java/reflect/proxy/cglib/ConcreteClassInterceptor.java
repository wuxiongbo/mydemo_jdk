package reflect.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import reflect.proxy.cglib.methodproxysource.MethodInterceptor1;
import reflect.proxy.cglib.methodproxysource.MethodProxy1;

import java.lang.reflect.Method;

/**
 * <p> 自定义 方法拦截器 </p>
 *  拦截器 需要实现 MethodInterceptor 接口
 *
 *  在调用目标方法时，CGLib会 回调 MethodInterceptor接口的方法  进行拦截，来实现你自己的代理逻辑，类似于JDK中的InvocationHandler接口。
 *
 *  在本示例中，只在 调用 ‘被代理类’方法 前、后 各打印了一句话，当然实际编程中可以是其它复杂逻辑。
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
public class ConcreteClassInterceptor implements MethodInterceptor {

    private final Object object;

    // 依赖注入 被代理的原始对象
    public ConcreteClassInterceptor(Object object){
        this.object = object;
    }

    /**
     * @param proxy         由CGLib动态生成的代理类实例
     * @param method        被代理类的原方法引用
     * @param args          方法参数值列表
     * @param methodProxy   代理类的代理后方法引用。  {@link MethodProxy1}
     *
     * @return            从代理实例的方法调用返回的值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        String methodName = method.getName();

        Object result;

        // 只代理test方法
        if ("test".equals(methodName)){
            // proxy 是代理，那如何获取 proxy 的父类？
            System.out.println("proxy:" + proxy.getClass());


            System.out.println("前置增强，Before:"+method);

            // 调用 代理类的父类的方法（这里指的，实体类ConcreteClassNoInterface中对应的方法）
            result = methodProxy.invokeSuper(proxy, args);
            System.out.println("result:"+result);

            System.out.println("后置增强，After:"+method);

        }else {
            result = methodProxy.invokeSuper(proxy, args);
        }


        return result;
    }
}
