package java8.innerclass;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2022/1/22
 * </pre>
 */
public class Main {
    public static void main(String[] args){
        Outer outer = new Outer();

        Outer.Inner inner = outer.new Inner();

        inner.printOuterInt();

    }
}
