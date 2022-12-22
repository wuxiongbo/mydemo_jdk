package genericity;

import genericity.hold.A;
import genericity.hold.B;
import genericity.hold.Hold;

/**
 * <p>泛型擦除</p>
 *
 * 泛型擦除导致 编译期 放弃类型校验。
 *
 * <pre>
 * @author wuxiongbo
 * @date 2022/1/14
 * </pre>
 */
public class Demo {

    // 依赖注入
    BizService bizService;


    void test(){

//        Hold<B> b1Hold = bizService.getHold();


        Hold hold = new Hold<A>();

        // 传入原生类型，导致编译期放弃泛型校验。 方法 返回 Hold<A> ，确可以用 Hold<B> 接收
        Hold<B> b2Hold = bizService.getHold(hold);


        b2Hold = hold;

    }

}
