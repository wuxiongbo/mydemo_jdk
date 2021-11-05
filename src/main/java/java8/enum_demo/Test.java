package java8.enum_demo;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/11/5
 * </pre>
 */
public class Test {
    public static void main(String[] args){
        String name = Person.DEVELOPER.name();
        System.out.println(name);

        Person dingding = Person.valueOf("DINGDING");
        System.out.println(dingding);

        Person[] values = Person.values();


    }
}
