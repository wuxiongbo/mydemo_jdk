package reflect.jdk_reflect;

import org.junit.jupiter.api.Test;
import reflect.po.SampleClass;
import reflect.po.UserInfo;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

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
//@Slf4j
public class PropertyDescriptorDemo {


    @Test
    void test1(){
        Method[] methods = SampleClass.class.getMethods();

        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].toGenericString());
        }
    }

    @Test
    void test2() throws Exception {
        UserInfo user= new UserInfo();

        setProperty(user,"userName");

        System.out.println("set userName:" + user.getUserName());

        Object rtValue = getProperty(user,"userName");

        System.out.println("get userName:" + rtValue.toString());
    }

    /**
     * 通过属性名，设置bean的属性值
     */
    public static void setProperty(Object user, String propertyName) throws Exception {
        // 获取bean的某个属性的描述符
        PropertyDescriptor propDesc = new PropertyDescriptor(propertyName, UserInfo.class);
        // 获得用于写入属性值的方法
        Method writeMethod = propDesc.getWriteMethod();
        // 写入属性值
        writeMethod.invoke(user, "zhangsan");
    }

    /**
     * 通过属性名，获取bean的属性值
     */
    public static Object getProperty(Object user, String propertyName) throws Exception {
        // 获取Bean的某个属性的描述符
        PropertyDescriptor proDescriptor = new PropertyDescriptor(propertyName, UserInfo.class);
        // 获得用于读取属性值的方法
        Method readMethod = proDescriptor.getReadMethod();
        // 读取属性值
        Object rtValue = readMethod.invoke(user);

        return rtValue;

    }

}
