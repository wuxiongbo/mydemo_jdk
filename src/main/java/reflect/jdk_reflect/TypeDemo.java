package reflect.jdk_reflect;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * <p> Java中获取泛型的Class对象  工具类的使用 </p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/10/28
 * </pre>
 */
public class TypeDemo {
    public static void main(String[] args){
        // 注意，创建的是，加了 {} 的匿名类
        ParameterizedTypeReference parameterizedTypeReference = new ParameterizedTypeReference<ArrayList<Integer>>(){};

        Type type = parameterizedTypeReference.getType();
        // java.util.ArrayList<java.lang.Integer>

        System.out.println(type);

    }


}
