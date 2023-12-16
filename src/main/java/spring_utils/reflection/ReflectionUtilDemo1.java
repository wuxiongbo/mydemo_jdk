package spring_utils.reflection;


import org.springframework.util.ReflectionUtils;
import reflect.po.UserInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * <p>  Spring 工具类 ReflectionUtils </p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
public class ReflectionUtilDemo1 {
    public static void main(String[] args){
        // 类信息
        String fieldName = "userName";
        String methodName = "setUserName";
        Class<UserInfo> clazz = UserInfo.class;

        // 类的对象实例
        UserInfo user = new UserInfo();
        user.setUserId(111L);
        user.setUserName("zhangsan");
        user.setAge(18);
        user.setEmailAddress("1111@ww.com");

        // 获取属性对象
        Field field = ReflectionUtils.findField(clazz, fieldName, String.class);
        assert field != null;
        field.setAccessible(true);
        System.out.println(field);
        // 获取属性的值
        Object fieldValue= ReflectionUtils.getField(field, user);
        System.out.println(fieldValue);

        // 获取方法对象
        Method[] declaredMethods = ReflectionUtils.getDeclaredMethods(clazz);
        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.getName().equals(methodName)){
                System.out.println(declaredMethod);
            }
        }


    }
}
