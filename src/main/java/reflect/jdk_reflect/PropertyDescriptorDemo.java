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
    /**
     * 获取并打印 SampleClass类拥有的所有方法。
     */
    void test1(){
        Method[] methods = SampleClass.class.getMethods();

        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].toGenericString());
        }
    }

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
