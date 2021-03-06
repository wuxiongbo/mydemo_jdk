package reflect.proxy.parameterized_type.interfaces;

/**
 * <p>泛型的使用</p>
 * 代码含义：
 *   接口 Interface4  用到两个泛型， R 、T
 *   T 的约束：
 *      1.  T 必须继承自 Interface1 接口。
 *      2.  Interface1 必须是 R类型 接口。
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/1
 * </pre>
 */
public interface Interface4<R,T extends Interface1<R>> {

    /**
     * <A,B,C,D> 表示 本方法将用到 A,B,C,D 四种泛型
     * @param <A>
     * @param <B>
     * @param <C>
     * @param <D>
     */
    default <A,B,C,D> void demo(Class<A> clazz) throws IllegalAccessException, InstantiationException {
        A a= clazz.newInstance();
        System.out.println(a);
    }

    /**
     * 约束 泛型A 必须为 Interface1 的子类。
     * @param <A>
     */
    public <A extends Interface1<?>> void demo2(A a);

}
