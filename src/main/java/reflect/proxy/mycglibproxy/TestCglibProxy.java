package reflect.proxy.mycglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Jonathan
 * <p>
 * 第一种是通过 ajc 编译器在**编译** class 类文件时，就把通知的增强功能，织入到目标类的字节码中
 * 第二种是通过 agent 在**加载**目标类时，修改目标类的字节码，织入增强功能
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        Target proxy = (Target) Enhancer.create(Target.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before...");
//            Object result = method.invoke(target, args); // 用方法反射调用目标
                // methodProxy 它可以避免反射调用
//            Object result = methodProxy.invoke(target, args); // 内部没有用反射, 需要目标 （spring）
                Object result = methodProxy.invokeSuper(o, args); // 内部没有用反射, 需要代理
                System.out.println("after...");
                return result;
            }
        });
        proxy.foo();
    }

    static class Target {
        public void foo() {
            System.out.println("target foo");
        }
    }
}
