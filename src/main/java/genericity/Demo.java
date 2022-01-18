package genericity;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2022/1/14
 * </pre>
 */
public class Demo {

    BizService bizService;

    void test(){

//        Hold<B> b1Hold = bizService.getHold();

        Hold hold = new Hold();

        Hold<B> b2Hold = bizService.getHold(hold);

        b2Hold = hold;

    }

}
