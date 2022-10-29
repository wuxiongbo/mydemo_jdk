package jdk_proxy.static_proxy2;

import jdk_proxy.bean.Student;

/**
 * @author Xander Wu
 * @date 2022/10/26 15:27
 */
public class StudentProxy extends Student {
    @Override
    public void sayHello(String content, int age) {
        System.out.println("Proxy sayHello begin");

        //在代理类的方法中 间接访问被代理对象的方法
        super.sayHello(content, age);

        System.out.println("Proxy sayHello end");
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("Proxy sayGoodBye begin");

        //在代理类的方法中 间接访问被代理对象的方法
        super.sayGoodBye(seeAgin, time);

        System.out.println("Proxy sayGoodBye end");
    }

    @Override
    public void say(){
        super.say();
    }

}
