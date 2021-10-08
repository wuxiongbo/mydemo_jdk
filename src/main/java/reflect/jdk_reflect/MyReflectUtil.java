package reflect.jdk_reflect;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/15
 * </pre>
 */
public class MyReflectUtil {

    /**
     * 实例化 私有普通内部类
     * @param outClzz     外部类的class对象
     * @param innerName   内部类的短名称
     * @param args        内部类构造方法参数
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Object getNormalInner(Class outClzz,String innerName,Object ... args) throws Exception {
        //获取外部类

        //获取外部类默认无参构造方法，实例一个外部类对象
        Constructor con = outClzz.getDeclaredConstructor();

        Object outObj = con.newInstance();

        //获取外部类内的所有内部类
        Class innerClazz[] = outClzz.getDeclaredClasses();
        for (Class inner : innerClazz) {
            // 获取修饰符的整数编码
            int mod = inner.getModifiers();
            // 返回整数编码对应的修饰符的字符串对象
            String modifier = Modifier.toString(mod);
            // 找到被private修饰的内部类
            if (modifier.contains("private")) {
                if(innerName.equals(inner.getSimpleName())){
                    Class<?>[] types = new Class[args.length+1];
                    if(args!=null){
                        int i =1;
                        for (Object arg : args) {
                            if(arg instanceof Class){
                                types[i]= Class.class;
                            }else if(arg instanceof ConcurrentHashMap){
                                types[i]= Map.class;
                            }else{
                                types[i]= arg.getClass();
                            }
                            i++;
                        }
                    }
                    types[0]=outClzz; //(普通内部类 的构造方法有隐藏参数，参数列表的第一个参数位置，这个隐藏参数是 外部类的实例)

                    //根据内部类的特性，需要由外部类来反射获取内部类的构造方法（这里获取的是内部类的默认构造方法）
                    Constructor constructor = inner.getDeclaredConstructor(types);
                    //由于内部类是私有的，需要强制获取构造方法的访问权限
                    constructor.setAccessible(true);

                    Object[] params = new Object[args.length+1];
                    System.arraycopy(args,0,params,1,args.length);
                    params[0] = outObj;

                    //用 内部类的构造方法对象 来反射获取内部类的实例化对象(普通内部类 需要传入外部类的实例，它是构造方法的隐藏参数)
                    Object innerObj = constructor.newInstance(params);
                    return innerObj;
                }

            }
        }

        return null;
    }


    /**
     * 实例化 私有静态内部类
     * @param outClzz
     * @param innerName
     * @param args
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Object getStaticInner(Class outClzz,String innerName,Object ... args) throws Exception {

        //获取外部类内的所有内部类
        Class innerClazz[] = outClzz.getDeclaredClasses();
        for (Class inner : innerClazz) {
            // 获取修饰符的整数编码
            int mod = inner.getModifiers();
            // 返回整数编码对应的修饰符的字符串对象
            String modifier = Modifier.toString(mod);
            // 找到被private修饰的内部类
            if (modifier.contains("private")) {
                if(innerName.equals(inner.getSimpleName())){
                    Class<?>[] types = new Class[args.length];
                    if(args!=null){
                        int i =0;
                        for (Object arg : args) {
                            if(arg instanceof Class){
                                types[i]= Class.class;
                            }else if(arg instanceof ConcurrentHashMap){
                                types[i]= Map.class;
                            }else{
                                types[i]= arg.getClass();
                            }
                            i++;
                        }
                    }

                    //根据内部类的特性，需要由外部类来反射获取内部类的构造方法（这里获取的是内部类的默认构造方法）
                    Constructor constructor = inner.getDeclaredConstructor(types);
                    //由于内部类是私有的，需要强制获取构造方法的访问权限
                    constructor.setAccessible(true);


                    //用 内部类的构造方法对象 来反射获取内部类的实例化对象(静态内部类 没有构造方法的隐藏参数)
                    Object innerObj = constructor.newInstance(args);
                    return innerObj;
                }

            }
        }

        return null;
    }


    /**
     * 通过属性名，设置bean的属性值
     */
    public static void setProperty(Object target, String propertyName) throws Exception {
        // 获取bean的某个属性的描述符
//        PropertyDescriptor propDesc = new PropertyDescriptor(propertyName, UserInfo.class);
        PropertyDescriptor propDesc = new PropertyDescriptor(propertyName, target.getClass());

        // 获得用于写入属性值的方法
        Method writeMethod = propDesc.getWriteMethod();
        // 写入属性值
        writeMethod.invoke(target, "zhangsan");
    }


    /**
     * 通过属性名，获取bean的属性值
     */
    public static Object getProperty(Object target, String propertyName) throws Exception {
        // 获取Bean的某个属性的描述符
//        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, UserInfo.class);
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, target.getClass());

        // 获得用于读取属性值的方法
        Method readMethod = propertyDescriptor.getReadMethod();
        // 读取属性值 并返回
        Object rtValue = readMethod.invoke(target);
        return rtValue;
    }


}
