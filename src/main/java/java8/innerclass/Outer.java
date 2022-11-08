package java8.innerclass;

/**
 * <p>内部类 可以访问外围类 的私有成员</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2022/1/22
 * </pre>
 */
public class Outer {

    private int outerInt;


    class Inner {

        public void printOuterInt() {

            System.out.println("Outer int = " + outerInt);

        }
    }
}