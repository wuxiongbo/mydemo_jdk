package jdk_proxy.bean;

/**
 *
 *  需要被代理的类 实现了一个接口Person
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class Student implements Person {

    @Override
    public void sayHello(String content, int age) {
        System.out.println("student sayHello " + content + " "+ age);


        System.out.println("sayHello() call sayGoodBye() ------ begin");
        this.sayGoodBye(true,11111D);
        System.out.println("sayHello() call sayGoodBye() ------ end");

        System.out.println("=================");
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("student sayGoodBye " + time + " "+ seeAgin);
    }


    // 方法 自调用 示例
    public void say(){
        this.sayHello("welcome to java", 20);  // 调用子类重写后的方法
        System.out.println("--------------------");
        this.sayGoodBye(true, 100);           // 调用子类重写后的方法
    }

}