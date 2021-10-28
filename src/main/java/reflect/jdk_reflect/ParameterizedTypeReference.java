package reflect.jdk_reflect;

import org.springframework.util.Assert;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p> Java中获取泛型的Class对象 工具类 </p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/10/28
 * </pre>
 */
public abstract class ParameterizedTypeReference<T> {

    private final Type type;

    // 构造方法
    protected ParameterizedTypeReference() {
        Class<?> parameterizedTypeReferenceSubclass = findParameterizedTypeReferenceSubclass(this.getClass());
        // 获取父类的泛型类 ParameterizedTypeReference<具体类型>
        Type type = parameterizedTypeReferenceSubclass.getGenericSuperclass();

        // 断言：必须是 ParameterizedType
        Assert.isInstanceOf(ParameterizedType.class, type, "Type must be a parameterized type");

        ParameterizedType parameterizedType = (ParameterizedType)type;
        // 获取泛型的具体类型  这里是单泛型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

        // 断言：必须是单泛型
        Assert.isTrue(actualTypeArguments.length == 1, "Number of type arguments must be 1");    // 设置结果

        this.type = actualTypeArguments[0];
    }

    // 这个方法开放出去，用来调用 获取泛型的具体Class类型
    public Type getType() {
        return this.type;
    }

    private static Class<?> findParameterizedTypeReferenceSubclass(Class<?> child) {
        Class<?> parent = child.getSuperclass();
        // 如果父类是Object 就没戏了
        if (Object.class == parent) {
            throw new IllegalStateException("Expected ParameterizedTypeReference superclass");
        } else {
            // 如果 父类是 工具类本身 就返回，否则就递归， 直到获取到 ParameterizedTypeReference 工具类本身
            return ParameterizedTypeReference.class == parent ? child : findParameterizedTypeReferenceSubclass(parent);
        }
    }
}
