package spring_utils.reflection;


import org.springframework.util.ReflectionUtils;
import reflect.po.UserInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * <p>  Spring 工具类 ReflectionUtils </p>
 *
 * 获取方法的返回值类型
 *
 * @author wuxiongbo
 * @date 2021/6/17
 */
public class ReflectionUtilDemo2 {
    public static void main(String[] args){
        // 类信息
        String methodName = "getUserName";
        Class<UserInfo> clazz = UserInfo.class;

        // 获取方法对象
        Method[] declaredMethods = ReflectionUtils.getDeclaredMethods(clazz);
        Method method = null;
        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.getName().equals(methodName)){
                method = declaredMethod;
                System.out.println(declaredMethod);
                break;
            }
        }

        assert method != null;
        Class<?> returnType = method.getReturnType();
        System.out.println(returnType);

    }
}
