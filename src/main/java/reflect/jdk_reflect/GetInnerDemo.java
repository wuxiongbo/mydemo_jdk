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
//        Class<A> aClass = A.class;
//        Constructor<A> constructor = aClass.getConstructor(Class.class);
//        A a = constructor.newInstance(String.class);

        //获取外部类
        Class<Out> clzz = Out.class;

        MyReflectUtil util = new MyReflectUtil();

        Class<String> stringClass = String.class;
        Object inner1 = util.getStaticInner(clzz, "Inner",stringClass);
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

class A{
    private Class<?> clazz;

    public A(Class<?> clazz) {
        this.clazz = clazz;
    }
}