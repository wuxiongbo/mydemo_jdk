package spring;

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

        Field userNameField = ReflectionUtils.findField(UserInfo.class, "userName", String.class);
        userNameField.setAccessible(true);

        System.out.println(userNameField);

        UserInfo user = new UserInfo()
                .setUserId(111L)
                .setUserName("zhangsan")
                .setAge(18)
                .setEmailAddress("1111@ww.com");

        String userName= (String)ReflectionUtils.getField(userNameField, user);

        System.out.println(userName);
    }
}
