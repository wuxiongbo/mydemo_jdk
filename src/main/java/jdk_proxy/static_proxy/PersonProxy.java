package jdk_proxy.static_proxy;

import jdk_proxy.bean.Person;

/**
 *
 *  静态代理，这个代理类也必须要实现和被代理类相同的Person接口
 *
 *  Static proxy
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class PersonProxy implements Person {

    private Person o;

    public PersonProxy(Person o){
        this.o = o;
    }


    @Override
    public void sayHello(String content, int age) {
        System.out.println("ProxyTest sayHello begin");

        //在代理类的方法中 间接访问被代理对象的方法
        o.sayHello(content, age);

        System.out.println("ProxyTest sayHello end");
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("ProxyTest sayHello begin");

        //在代理类的方法中 间接访问被代理对象的方法
        o.sayGoodBye(seeAgin, time);

        System.out.println("ProxyTest sayHello end");
    }

}

