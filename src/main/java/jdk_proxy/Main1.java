package jdk_proxy;

import jdk_proxy.bean.Person;
import jdk_proxy.bean.Student;
import jdk_proxy.dynamic_proxy.MyInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * <p>jdk动态代理</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/18
 * </pre>
 */
public class Main1 {
    public static void main(String [] args){
        //这一句是生成代理类的class文件，前提是你需要在工程根目录下创建com/sun/proxy目录，不然会报找不到路径的io异常
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");


        //一、创建需要被代理的类
        Student student = new Student();

        //二、创建代理
        // 1.获得加载被代理类的 “类加载器”
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        // 2.指明被代理类实现的 “接口”
        Class<?>[] interfaces = student.getClass().getInterfaces();
        // 3.创建被代理类的 “委托类”。之后，每调用被代理类的方法，都会委托给这个类的invoke(Object proxy, Method method, Object[] args)方法
        MyInvocationHandler h = new MyInvocationHandler(student);

        // 4.生成代理类
        Person proxy = (Person) Proxy.newProxyInstance(loader, interfaces, h);


        //三、通过代理类  调用被代理类的方法
        proxy.sayHello("zhangsan", 20);
        proxy.sayGoodBye(true, 100);

        System.out.println("end");
    }
}
