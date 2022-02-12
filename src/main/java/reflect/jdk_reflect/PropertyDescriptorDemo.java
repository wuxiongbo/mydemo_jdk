package reflect.jdk_reflect;

import org.junit.jupiter.api.Test;
import org.springframework.asm.ClassReader;
import org.springframework.asm.ClassVisitor;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.util.ClassUtils;
import reflect.po.SampleClass;
import reflect.po.UserInfo;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static reflect.jdk_reflect.MyReflectUtil.*;

//https://www.yiibai.com/javareflect/javareflect_method_togenericstring.html
//https://blog.csdn.net/weixin_42069143/article/details/82119724
//https://blog.csdn.net/zhuqiuhui/article/details/78542049

/**
 * <p>  PropertyDescriptor 属性描述符</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
public class PropertyDescriptorDemo {


    @Test
    /**
     * 获取并打印 SampleClass类拥有的所有方法的参数类型。
     */
    void test11(){
        Method[] methods = SampleClass.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Class<?>[] parameterTypes = methods[i].getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName());
            }
        }

        try{
            String p = "long";
            Class<?> aLong = getType(p);
            if (p!=null && aLong==null){
                aLong = Class.forName(p);
            }

            Class<Long> longClass = long.class;
            System.out.println("===="+ aLong);
            System.out.println(longClass);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    /**
     * 基本数据类型 不能用 Class.forName;  所以，需要显示创建。
     * @param p
     * @return
     */
    private Class<?> getType(String p){
        switch (p){
            case "byte":
                return byte.class;
            case "short":
                return short.class;
            case "int":
                return int.class;
            case "long":
                return long.class;
            case "float":
                return float.class;
            case "double":
                return double.class;
            case "boolean":
                return boolean.class;
            case "char":
                return char.class;
            default:
                return null;
        }
    }


    @Test
    /**
     * 获取并打印 SampleClass类拥有的所有方法。
     */
    void test1(){
        Method[] methods = SampleClass.class.getMethods();

        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].toGenericString());
        }
    }
    /*
    打印输出：
    SampleClass
        public boolean reflect.po.SampleClass.equals(java.lang.Object)
        public java.lang.String reflect.po.SampleClass.toString()
        public int reflect.po.SampleClass.hashCode()
        public void reflect.po.SampleClass.setSampleField(java.lang.String)
        public java.lang.String reflect.po.SampleClass.getSampleField()

    Object
        public final void java.lang.Object.wait() throws java.lang.InterruptedException
        public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
        public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
        public final native java.lang.Class<?> java.lang.Object.getClass()
        public final native void java.lang.Object.notify()
        public final native void java.lang.Object.notifyAll()
     */


    /**
     * 通过反射的方式，读取或写入 实例对象的属性值
     * @throws Exception
     */
    @Test
    void test2() throws Exception {
        UserInfo user= new UserInfo();

        // 写入属性值
        setProperty(user,"userName");
        System.out.println("set userName:" + user.getUserName());

        // 读取属性值
        Object rtValue = getProperty(user,"userName");
        System.out.println("get userName:" + rtValue.toString());
    }


    /**
     * 反射获取参数名称
     * @throws NoSuchMethodException
     */
    @Test
    void test3() throws NoSuchMethodException {
        Method setUserName = UserInfo.class.getMethod("setUserName",String.class);

        Executable executable = setUserName;
        Class<?> declaringClass = executable.getDeclaringClass();
        String classFileName = ClassUtils.getClassFileName(declaringClass);  // spring

        MyReflectUtil util = new MyReflectUtil();

        try (InputStream is = declaringClass.getResourceAsStream(classFileName)){
            Map<Executable, String[]> map = new ConcurrentHashMap<>(32);

            ClassReader classReader = new ClassReader(is);  // spring
            classReader.accept(
                    // 实例化私有静态内部类
                    (ClassVisitor)util.getStaticInner(
                            LocalVariableTableParameterNameDiscoverer.class,
                            "ParameterNameDiscoveringVisitor",
                            declaringClass,map),
                    0);


            String[] strings = map.get(executable);

            System.out.println(Arrays.toString(strings));

        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }


    @Test
    void test4() throws NoSuchMethodException {

        Object user= new UserInfo();
        Class<?> aClass = user.getClass();
        System.out.println(aClass);
    }

}
