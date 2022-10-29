package reflect.proxy.cglib;

/**
 * <p> 被代理类</p>
 * <p>
 * 该类 没有实现任何接口、仅包含两个方法
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
public class ConcreteClassNoInterface {
    public String getConcreteMethodA(String str) {
        System.out.println("ConcreteMethod A ... " + str);

        test("");

        return str;
    }

    public int getConcreteMethodB(int n) {
        System.out.println("ConcreteMethod B ... " + n);
        return n + 10;
    }

    public String test(String input) {
        return "hello world";
    }

}
