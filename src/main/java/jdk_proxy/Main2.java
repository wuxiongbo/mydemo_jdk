package jdk_proxy;

import jdk_proxy.bean.Student;
import jdk_proxy.static_proxy.PersonProxy;
import jdk_proxy.static_proxy2.StudentProxy;

/**
 * <p>静态代理</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/18
 * </pre>
 */
public class Main2 {

    public static void main(String[] args) {
        // student 为被代理的对象，某些情况下 我们不希望修改已有的代码，我们采用代理来间接访问 student
        Student student = new Student();



        //创建 静态代理类对象
        PersonProxy proxy = new PersonProxy(student);


        //调用 代理类对象的方法
        proxy.sayHello("welcome to java", 20);

        System.out.println("******");

        //调用代理类对象的方法
        proxy.sayGoodBye(true, 100);




        System.out.println("=======示例2：方法自调用=====");


        StudentProxy studentProxy = new StudentProxy();
        studentProxy.say();


    }

}
