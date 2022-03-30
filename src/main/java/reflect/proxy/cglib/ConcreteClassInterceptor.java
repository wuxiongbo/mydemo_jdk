package reflect.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p> 自定义拦截器 </p>
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

    /**
     * @param obj         由CGLib动态生成的代理类实例
     * @param method      被代理类的方法引用
     * @param args        方法参数值列表
     * @param proxy       代理类的代理方法引用
     *
     * @return            从代理实例的方法调用返回的值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // obj是代理，那如何获取 obj 的父类？
        System.out.println("obj:"+obj.getClass());



        System.out.println("前置增强，Before:"+method);

        // 调用 代理类的父类的方法（这里指的，实体类ConcreteClassNoInterface中对应的方法）
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("result:"+result);


        System.out.println("后置增强，After:"+method);

        return result;
    }
}
