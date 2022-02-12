package reflect.spring.reflection_utils;


import org.springframework.util.ReflectionUtils;
import reflect.po.UserInfo;

import java.lang.reflect.Field;

/**
 * <p>  Spring 工具类 ReflectionUtils </p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
public class SpringDemo {
    public static void main(String[] args){
        // 反射 获取 属性对象
        Field userNameField = ReflectionUtils.findField(UserInfo.class, "userName", String.class);
        userNameField.setAccessible(true);
        System.out.println(userNameField);

        // 实例
        UserInfo user = new UserInfo();
        user.setUserId(111L);
        user.setUserName("zhangsan");
        user.setAge(18);
        user.setEmailAddress("1111@ww.com");

        // 获取属性的值
        Object fieldValue= ReflectionUtils.getField(userNameField, user);
        System.out.println(fieldValue);

    }
}
