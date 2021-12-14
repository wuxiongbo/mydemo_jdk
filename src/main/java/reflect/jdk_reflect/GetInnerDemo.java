package reflect.jdk_reflect;

import java.lang.reflect.Constructor;

/**
 * <p> 通过反射获取私有内部类对象 </p>
 *
 * https://blog.csdn.net/GD_Hacker/article/details/80272159
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/15
 * </pre>
 */
public class GetInnerDemo {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws Exception {
        // 示例：构建普通类
        Class<A> aClass = A.class;
        Constructor<A> constructor = aClass.getConstructor(Class.class);
        A a = constructor.newInstance(String.class);



        // 示例：构建静态内部类
        // 外部类的class对象
        Class<Out> clzz = Out.class;
        // 获取  私有化的静态 内部类
        MyReflectUtil util = new MyReflectUtil();
        Object inner1 = util.getStaticInner(clzz, "Inner",String.class);
        System.out.println(inner1);

//        Object inner = util.getNormalInner(clzz, "Inner","42342323",21313);
//        System.out.println(inner);
//
//        Object name = MyReflectUtil.getProperty(inner, "name");
//        Object age = MyReflectUtil.getProperty(inner, "age");
//
//
//        System.out.println(name);
//        System.out.println(age);
    }
}



/**
 * 静态内部类
 */
class Out {
    //目标获取Inner对象
    private static class Inner {
        //内部类的私有成员属性
        private String name = "ccc";

        private Integer age = 0;

        private Class<?> clazz;

        public Inner() {
        }

        public Inner(String inner) {
            this.name = inner;
        }

        public Inner(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Inner(Class<?> clazz) {
            this.clazz = clazz;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Class<?> getClazz() {
            return clazz;
        }

        public void setClazz(Class<?> clazz) {
            this.clazz = clazz;
        }
    }
}

/**
 * 构造方法 中有 class 类型参数
 *
 * 普通内部类
 */
class A{
    private Class<?> clazz;

    public A(Class<?> clazz) {
        this.clazz = clazz;
    }

    private class B{
    }
}