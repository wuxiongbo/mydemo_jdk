package reflect.jdk_reflect.bridge.dependence;

/**
 * <p>桥接方法</p>
 *
 * 因为泛型是在1.5引入的，为了向前兼容，所以会在编译时去掉泛型（泛型擦除）。
 * 那么SuperClass接口中的method方法的参数在虚拟机中只能是Object。它应该是这个样子：
 *
 * public interface SuperClass {
 *     void method(Object t);
 * }
 *
 *
 * 而 AClass 实现了SuperClass 接口，但是它的实现方法却是：
 *
 * public void method(String s) {
 * 　　System.out.println(s);
 * }
 *
 * 根本就没有实现 void method(Object t) 方法。 这是怎么回事呢？
 * 其实，虚拟机 为AClass 自动实现了一个方法。
 *
 * 我们使用javap指令，反编译AClass
 *
 * javap 指令
 * D:\soft\tools\jdk-17\bin>javap -p AClass.class
 *
 * ----------------------------------编译后，内容如下---------------------------------------------------------------------------
 * Compiled from "AClass.java"
 * public class reflect.jdk_reflect.Bridge.AClass implements reflect.jdk_reflect.Bridge.SuperClass<java.lang.String> {
 *   public reflect.jdk_reflect.Bridge.AClass();
 *   public void method(java.lang.String);
 *   public void method(java.lang.Object);
 * }
 *
 * 把关键部分拧出来：
 *   method(Ljava/lang/String;)V
 *   method(Ljava/lang/Object;)V
 * -------------------------------------------------------------------------------------------------------------------------
 *
 * 可以看到，class文件中，多出了一个方法，这个方法就是 桥接方法。
 * 也就是说，JVM 在编译时，为我们 隐式地 创建了 桥接方法。
 *
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