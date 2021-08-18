package reflect.cast;

/**
 * <p>类的类型cast（Object o）方法的说明</p>
 *
 * Java程序演示示例
 *
 * https://blog.csdn.net/a1064072510/article/details/84653333
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/1
 * </pre>
 */
interface IA{
}

class A implements IA{
    //A空白实施
}

class B extends A {
    //B1空白实施
}

/**
 * isInstance方法
 * 官方文档:
 * Class.isInstance(Object)
 * 用于判定指定的 Object 是否与此 Class 所表示的对象赋值兼容。
 * 此方法是 Java 语言 instanceof 运算符的 “动态等效方法” 。
 *
 * 如果指定的 Object 参数非空，且能够在不引发 ClassCastException 的情况下被强制转换成该 Class 对象所表示的引用类型，则该方法返回 true；否则返回 false。
 *    如，b_a 能被强制转换成 B ，则  B.class.isInstance(b_a)   返回true 否则false
 *
 * 特别地，当该 Class 对象表示一个已声明的类时，若指定的 Object 参数是所表示类（或其任一子类）的一个实例，则此方法返回 true；否则返回 false。
 *    如，b_a 是 A 的任意子类，则   A.class.isInstance(b_a)   返回true 否则false
 *
 * 如果此 Class 对象表示一个数组类，且通过身份转换或扩展引用转换，指定的 Object 参数能转换为一个数组类的对象，则返回 true；否则返回 false。
 * 如果此 Class 对象表示一个接口，且指定 Object 参数的类或任一超类实现了此接口，则此方法返回 true；否则返回 false。
 *    如果ba 是 IA 的实现 或 ba的超类是 IA的实现，返回true 否则false
 * 如果此 Class 对象表示一个基本类型，则此方法返回 false。
 *
 * @author wuxiongbo
 */
public class MainClass {
    public static void main(String[] args) {

        //创建类A1和B1的实例
        A a = new A();
        A b_a = new B();

        //使用cast(b)方法将对象b转换为B类型
        B b = B.class.cast(b_a);

        //显示类别
        System.out.println("a.getClass(): " + a.getClass());
        System.out.println("ba.getClass(): " + b_a.getClass());
        System.out.println("b.getClass(): " + b.getClass());


        // cast 原理。 isInstance

        // isInstance是Class类的一个方法
        // ba 是不是 B 的实例。(重要，多态向下转型)
        System.out.println(B.class.isInstance(b_a));
        // ba 是不是 A 的实例
        System.out.println(A.class.isInstance(b_a));
        // ba 是不是 IA 的实例
        System.out.println(IA.class.isInstance(b_a));

        // instanceof 是一个操作符
        // ba 是不是 B 类型
        System.out.println(b_a instanceof B);
        // ba 是不是 A 类型
        System.out.println(b_a instanceof A);


    }
}
