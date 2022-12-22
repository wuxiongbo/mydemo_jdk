package java8.lambda;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * <p> LambdaMetafactory替代反射，提高效率 </p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/17
 * </pre>
 */
public class LambdaTest {

    public static void main(String[] args) {
        String className = "java8.lambda.Operation";
        String methodName = "operate";
        try {
            //通过全类名，获取类的实例
            Class<?> clazz = Class.forName(className);
            //获取到类的对象，要求该类必须有无参构造
            Operation operation = (Operation) (clazz.getConstructor().newInstance());
            //获取方法对象
            Method method = clazz.getDeclaredMethod(methodName, int.class, int.class, int.class);


            //=============重点来了，不通过反射，而是 使用LambdaMetafactory  调用方法。

            MethodHandles.Lookup lookup = MethodHandles.lookup();
            //指定方法不以反射运行
            MethodHandle methodHandle = lookup.unreflect(method);
            //获取方法的类型
            MethodType methodType = methodHandle.type();
            //将方法的实例对象类型加到方法类型工厂里
            MethodType factoryType = MethodType.methodType(Operator.class, methodType.parameterType(0));
            //移除方法里的实例对象类型
            methodType = methodType.dropParameterTypes(0, 1);

            //获取代理对象。
            Operator operator = (Operator) LambdaMetafactory
                    .metafactory(
                            lookup,
                            "toOperate", // 注意，第二个参数的字符串必须为函数式接口里的方法名
                            factoryType,
                            methodType,
                            methodHandle,
                            methodType)
                    .getTarget()
                    .invokeExact(operation);

            int operate = operator.toOperate(1, 2, 5);


            System.out.println(operate);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}

@FunctionalInterface
/**
 * 自定义的函数式接口，用于lambda调用
 */
interface Operator {
    /**
     * 入参应和被lambda调用的方法一致，在本例中是Operation中的operate方法
     *
     * @param a
     * @param b
     * @param c
     * @return 返回值应和被lambda调用的方法一致，在本例中是Operation中的operate方法
     */
    int toOperate(int a, int b, int c);
}


/**
 * 被lambda调用的类和方法
 */
class Operation {
    public Operation() {
    }

    public int operate(int a, int b, int c) {
        return a + b - c;
    }
}