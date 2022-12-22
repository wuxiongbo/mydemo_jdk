package genericity;

import genericity.hold.A;
import genericity.hold.Hold;

/**
 * <p>模拟 业务service层</p>
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
