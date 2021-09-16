package reflect.jdk_reflect.Bridge;

/**
 * <p>桥接方法</p>
 *
 * 因为泛型是在1.5引入的，为了向前兼容，所以会在编译时去掉泛型（泛型擦除）。
 * 那么SuperClass接口中的method方法的参数在虚拟机中只能是Object。它应该是这个样子：
 *
 * public interface SuperClass {
 *     void method(Object  t);
 * }
 *
 *
 * 而 AClass 实现了SuperClass 接口，但是它的实现方法却是：
 *
 * public void method(String s) {
 * 　　System.out.println(s);
 * }
 *
 * 根本就没有实现 void method(Object t) 方法。 这是怎么回事呢？ 其实，虚拟机自动实现了一个方法。
 *
 * 反编译AClass 可以看到，多出了一个方法，这个方法就是桥接方法。
 *
 * D:\soft\tools\jdk-17\bin>javap -p AClass.class
 * Compiled from "AClass.java"
 * public class reflect.jdk_reflect.Bridge.AClass implements reflect.jdk_reflect.Bridge.SuperClass<java.lang.String> {
 *   public reflect.jdk_reflect.Bridge.AClass();
 *   public void method(java.lang.String);
 *   public void method(java.lang.Object);
 * }
 *
 *
 * method(Ljava/lang/String;)V
 * method(Ljava/lang/Object;)V
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/15
 * </pre>
 */
public class AClass implements SuperClass<String> {
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}