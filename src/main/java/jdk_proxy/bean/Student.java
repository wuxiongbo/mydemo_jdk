package jdk_proxy.bean;

/**
 *
 *  需要被代理的类 实现了一个接口Person
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class Student implements Person{

    @Override
    public void sayHello(String content, int age) {
        System.out.println("student say hello" + content + " "+ age);
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("student sayGoodBye " + time + " "+ seeAgin);
    }

}