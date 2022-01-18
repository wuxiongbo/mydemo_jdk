package genericity;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2022/1/14
 * </pre>
 */
public interface BizService {

    Hold<A> getHold();

    Hold<A> getHold(Hold<A> hold);

}
