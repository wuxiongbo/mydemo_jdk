package reflect.proxy.mycglibproxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 1. method.invoke 是反射调用，必须调用到足够次数才会进行优化
 * 2. methodProxy.invoke 是不反射调用，它会正常（间接）调用目标对象的方法（Spring 采用）
 * 3. methodProxy.invokeSuper 也是不反射调用，它会正常（间接）调用代理对象的方法，可以省略目标对象
 *
 * @author Jonathan
 */
public class TestMyCglibProxy {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        Target target = new Target();
        proxy.setMethodInterceptor(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before............");
//                Object invoke = method.invoke(target, objects);
//                Object invoke = methodProxy.invokeSuper(o, args);
                Object invoke = methodProxy.invoke(target, objects);
                return invoke;
            }
        });
        proxy.save();
        proxy.save(1);
        proxy.save(100L);
    }
}
