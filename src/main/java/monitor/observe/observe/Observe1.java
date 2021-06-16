package monitor.observe.observe;

/**
 * <p>第一个观察者</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/16
 * </pre>
 */
public class Observe1 implements IObserve {
    @Override
    public void handleNotify(String message) {
        System.out.println("1号接受的消息"+message );
    }
}