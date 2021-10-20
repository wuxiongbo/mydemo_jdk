package reflect.jdk_reflect.Bridge;

import reflect.jdk_reflect.Bridge.dependence.AClass;

import java.lang.reflect.Method;

/**
 * <p> Java反射中method.isBridge() 判断是否为桥接方法 </p>
 *
 * https://www.cnblogs.com/zsg88/p/7588929.html
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/15
 * </pre>
 */
public class App {
    public static void main(String[] args) throws Exception {

        AClass obj = new AClass();
        Method m = AClass.class.getMethod("method", String.class);
        m.invoke(obj, "String参数类型的method");
        System.out.println(m.isBridge()); // false   不是桥接方法


        m = AClass.class.getMethod("method", Object.class);
        m.invoke(obj, "Object参数类型的method");
        System.out.println(m.isBridge()); // true    是桥接方法

    }
}
