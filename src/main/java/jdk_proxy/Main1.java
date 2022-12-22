package jdk_proxy;

import jdk_proxy.bean.Person;
import jdk_proxy.bean.Student;
import jdk_proxy.dynamic_proxy.StudentInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * <p>jdk动态代理</p>
 *
 * 关于 spring 事务 自调用失效的思考
 *
 * 首先，个人总结 对 "代理" 、 "装饰"  这两个概念的理解
 * 代理：
 *     代理类 完全可以取代  被代理的原始类 的 方法行为，从而 代理后的方法行为 与 原始类的方法行为 完全无关。而选择不增强。
 *     当然，也可以选择 代理类 将方法的实现 委托给  被代理的原始类，从而对原始类的方法增强。但是，这样做就有点类似 "装饰" 的思想
 * 装饰：
 *     装饰器，是对原始对象 方法的增强，不能改变原始对象 的行为的 原始意图。
 *
 *
 * 1) 从 jdk代理 分析，更容易理解。
 *    通常 我们会在 自己实现的  StudentInvocationHandler 里面依赖注入 原始对象。
 *    原始 Student对象 的 sayHello() 调用 自身的  sayGoodBye();
 *
 *
 *    proxy.sayHello() :
 *    使用 代理对象，调用 sayHello() 方法，正如本示例所示，在  InvocationHandler 实现中，我们 对 sayHello() 未作任何增强处理，而是 委托给了 原始对象实例。
 *    而 原始对象 的 sayHello() 方法  对 自身 sayGoodBye() 调用的 是未增强方法。所以，sayGoodBye() 未经过  InvocationHandler 拦截
 *
 *    proxy.sayGoodBye() :
 *    如果 使用 代理对象，直接调用 sayGoodBye() 方法， 则经过了  InvocationHandler 拦截。 实现了增强。
 *
 *
 *  2）回到 spring aop 中， 切面表达式 决定了拦截规则。
 *     InvocationHandler 通过解析出来的规则，决定 哪些方法需要放行，哪些方法需要增强。
 *     假设 sayGoodBye() 被事务注解修饰。
 *     那么，直接调用  proxy.sayGoodBye()时，  则会在 InvocationHandler 中的规则判断中被拦截。从而方法被增强
 *     而，调用 不被事务注解修饰的 sayHello() 方法时，则 在 InvocationHandler 中的规则判断中被放行， 委托给了 原始对象实例，未作任何增强处理
 *     从而  sayHello() 中 sayGoodBye() 的方法调用的是 原始类的。 而不是代理后被增强的。
 *
 *   也就是说，关键问题是。  同一个方法的 '反射调用' 与 '自身调用' 的区别；
 *   反射调用： 方法的主导权 交给我们 coder，可以对方法调用前后 作增强处理。
 *   自身调用： 方法的主导权 为方法所在的对象实例。 我们无法干预。
 *
 * 只有代理对象proxy，直接调用的那一个方法，才是真正的走代理
 *
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
        // 1. arg1 获得加载被代理类的 “类加载器”
        ClassLoader loader = Student.class.getClassLoader();
        // 2. arg2 指明被代理类实现的 “接口”
        Class<?>[] interfacesOfStudent = student.getClass().getInterfaces();
        // 3. arg3 创建 "被代理类" Student  的 “委托类” MyInvocationHandler。
        //   之后，每调用 "被代理类" 的方法，
        //   都会 委托给这个类的 invoke(Object proxy, Method method, Object[] args)方法
        StudentInvocationHandler h = new StudentInvocationHandler(student);

        // 4.生成 代理类 实例
        Person proxy = (Person) Proxy.newProxyInstance(loader, interfacesOfStudent, h);




        //三、通过代理类  调用被代理类的方法
        proxy.sayHello("zhangsan", 20);
        proxy.sayGoodBye(true, 100);

    }
}
