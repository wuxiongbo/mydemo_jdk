package reflect.jdk_reflect;

import org.springframework.util.Assert;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p> Java中获取泛型的Class对象 工具类 </p>
 *
 *  Class implements Type
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

        // 获取 匿名类的 class对象
        Class<?> parameterizedTypeReferenceSubclass = findParameterizedTypeReferenceSubclass(this.getClass());

        // 获取 匿名类 直接继承的 父类（包含泛型参数）
        Type type = parameterizedTypeReferenceSubclass.getGenericSuperclass();

        // 断言：父类 必须是 ParameterizedType。 即，参数化类型
        Assert.isInstanceOf(ParameterizedType.class, type, "Type must be a parameterized type");

        ParameterizedType parameterizedType = (ParameterizedType)type;
        // 获取 泛型类（参数化类型） 的具体类型参数， 这里是单泛型
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
            // 如果 父类是 ParameterizedTypeReference 工具类本身 就返回     匿名类，
            // 否则就递归， 直到获取到 某个类直接继承的父类是 ParameterizedTypeReference 工具类本身   就返回该类
            return ParameterizedTypeReference.class == parent ? child : findParameterizedTypeReferenceSubclass(parent);
        }
    }
}
