package monitor.event_jdk;

/**
 * <p>事件</p>
 *
 *  关键要素：提供 事件源 以及其他数据。
 *
 *  EventObject事件状态对象。 所有 派生的事件状态对象 的根类。
 *  所有的 事件对象 都是通过对 “source” 对象的引用来构造的， “source” 在逻辑上被认为是事件最初发生的对象。
 *
 *  一般情况下，监听器对象被事件触发后，都是需要从事件中获取到事件源对象，然后再从事件源中获取一些数据。
 *  也就是说，在事件对象中一般需要提供获取事件源对象的方法。
 *  当然，除了获取事件源方法外，根据业务需求，事件对象一般还需要提供一些其他的数据，以便让监听器获取。
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/16
 * </pre>
 */
import java.util.EventObject;

public class PrintEvent extends EventObject {
    private static final long serialVersionUID = 1L;

    /**
     * @param source 事件源
     */
    public PrintEvent(Object source) {
        // 保存 事件源
        super(source);
    }

    public void doEvent() {
        // getSource(),The object on which the Event initially occurred.
        // 获取事件源
        Object source = this.getSource();

        System.out.println("准备通知一个事件源 source: " + source);
    }

}
