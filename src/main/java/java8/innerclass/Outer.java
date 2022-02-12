package java8.innerclass;

/**
 * <p>描述类的信息</p>
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