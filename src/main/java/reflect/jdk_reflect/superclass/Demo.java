package reflect.jdk_reflect.superclass;

import org.junit.jupiter.api.Test;
import reflect.proxy.cglib.Main;
import temp.pk.ImportDemo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>查找父类</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
public class Demo {
    @Test
    void test1(){
        String a  = "121";

        List<Class<?>> clazzList = ClassUtil.getSuperClass(a.getClass());
        for (Class<?> clazz : clazzList) {
            System.out.println(clazz.toGenericString());
        }

    }

    @Test
    void test2(){
        try {
            System.out.println("获取路径下的所有类的文件名");

            for(Class<?> c: ClassUtil.getAllClass(ImportDemo.class)){
                System.out.println(c.getName());
            }

            //System.out.println("子类");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test3(){
        String a = "";


        Class<? extends String> aClass = a.getClass();

        //  aClass  是 CharSequence的子类 则正常运行。 否则抛异常
        Class<? extends CharSequence> aClass1 = aClass.asSubclass(CharSequence.class);


        //  内存地址。证实 aClass  和 aClass1  是同一个对象
        System.out.println(System.identityHashCode(aClass));
        System.out.println(System.identityHashCode(aClass1));
    }



    @Test
    void test4(){
//        String filepath = System.getProperty("user.dir");
//        System.out.println(filepath);

        try {
            Class<?> tempDemp = Class.forName("TempDemp");
            Object o = tempDemp.getConstructor().newInstance();

            System.out.println(o);
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }





    @Test
    void test5(){
//        Integer a = null;
//        System.out.println(a ==1);
        String s = "user/signUserRecord";
        System.out.println(s.contains("/signUserRecord"));

    }



}
