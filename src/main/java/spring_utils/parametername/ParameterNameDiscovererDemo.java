package spring_utils.parametername;

import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 获取方法的参数名
 * @author Xander Wu
 * @date 2023/12/11 14:47
 */
public class ParameterNameDiscovererDemo {

    public static void main(String[] args) {
        DefaultParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        // 类信息
        String methodName = "func";
        Class<Person> clazz = Person.class;

        // 获取方法对象
        Method[] declaredMethods = ReflectionUtils.getDeclaredMethods(clazz);
        Method method = null;
        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.getName().equals(methodName)){
                System.out.println(declaredMethod);
                method = declaredMethod;
                break;
            }
        }

        assert method != null;
        String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
        System.out.println(Arrays.toString(parameterNames));

    }
}
