package monitor.event;

import monitor.event.impl.Listener;
import monitor.event.impl.Listenerable;
import monitor.event.interfaces.IListener;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/16
 * </pre>
 */
public class Test {
    public static void main(String[] args) {
        //监听器 (观察者)
        IListener listener = new Listener();

        // 事件源 (被观察者)
        Listenerable listenerable = new Listenerable();

        //事件源 注册 监听器
        listenerable.setListener(listener);

        // 触发save事件。   被观察者 创建相应事件 并通知 观察者
        listenerable.save();

        // 触发remove事件。 被观察者 创建相应事件 并通知 观察者
        listenerable.remove();
    }
}

