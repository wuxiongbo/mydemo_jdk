package reflect.proxy.parameterized_type;

import java.util.Objects;
import java.util.function.Function;

/**
 * <p>这是jdk源码，这里抽出来，做泛型的学习示例</p>
 *  代码释义：
 *  类     BiFunction<T, U, R>
 *        说明： <T, U, R>  声明 本类会用到 T, U, R 这三个类型。 三个类型也可以不用。
 *
 *  方法   default <V> java.util.function.BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after)
 *        说明： 1. <V>
 *                    声明 本方法用到了  V 类型
 *              2. Function<? super R, ? extends V>
 *                    传入的参数是Function的实现类。 ？ 占位符表示实现类的类型。
 *
 *                      <1, 2>                 为了便于下面的描述，这里加个占位符位置标识
 *
 *                      <? super R, ? extends V> 就是对类型 ？ 的约束，具体如下：
 *                                                  占位符 位置1 代表的类 必须是R的父类，
 *                                                  占位符 位置2 代表的类 必须继承自V。
 *              3. java.util.function.BiFunction<T, U, V>
 *                     返回值是 BiFunction 类型。
 *
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/9
 * </pre>
 */
@FunctionalInterface
public interface BiFunction<T, U, R> {

    /**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument
     * @param u the second function argument
     * @return the function result
     */
    R apply(T t, U u);

    /**
     * Returns a composed function that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <V> the type of output of the {@code after} function, and of the
     *           composed function
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then
     * applies the {@code after} function
     * @throws NullPointerException if after is null
     */
    default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.apply(apply(t, u));
    }
}

