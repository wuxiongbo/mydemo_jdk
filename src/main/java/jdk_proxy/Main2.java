package jdk_proxy;

import jdk_proxy.bean.Student;
import jdk_proxy.static_proxy.PersonProxy;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/18
 * </pre>
 */
public class Main2 {

    public static void main(String[] args) {
        //s为被代理的对象，某些情况下 我们不希望修改已有的代码，我们采用代理来间接访问
        Student s = new Student();

        //创建代理类对象
        PersonProxy proxy = new PersonProxy(s);

        //调用代理类对象的方法
        proxy.sayHello("welcome to java", 20);

        System.out.println("******");
        //调用代理类对象的方法
        proxy.sayGoodBye(true, 100);

    }

}
