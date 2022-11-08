package reflect.jdk_reflect.bridge.dependence;

/**
 * <p>父类接口</p>
 *
 *
 * 由于泛型擦除，SuperClass接口 中的 method方法 的参数，在虚拟机中只能是Object。
 *
 * 它应该是这个样子：
 *
 * public interface SuperClass {
 *     void method(Object t);
 * }
 *
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/15
 * </pre>
 */
public interface SuperClass<T> {
    void method(T t);
}
