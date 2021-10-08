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
 *
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
//@Slf4j
public class PropertyDescriptorDemo {


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
        String classFileName = ClassUtils.getClassFileName(declaringClass);

        MyReflectUtil util = new MyReflectUtil();

        try (InputStream is = declaringClass.getResourceAsStream(classFileName)){

            ClassReader classReader = new ClassReader(is);
            Map<Executable, String[]> map = new ConcurrentHashMap<>(32);
            classReader.accept(
                    (ClassVisitor)util.getStaticInner(LocalVariableTableParameterNameDiscoverer.class,"ParameterNameDiscoveringVisitor",declaringClass,map),
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
