package monitor.event.impl;

import monitor.event.interfaces.IEvent;
import monitor.event.interfaces.IListener;
import monitor.event.interfaces.IListenerable;

/**
 * <p>事件源类(被观察者)</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/16
 * </pre>
 */
public class Listenerable implements IListenerable {

    private IListener listener;

    //注册监听器
    @Override
    public void setListener(IListener listener) {
        this.listener = listener;
    }

    //触发监听器
    @Override
    public void triggerListener(IEvent event) {
        listener.handleEvent(event);
    }

    public void save(){
        System.out.println("插入了一条数据");
        IEvent event = new Event(this,"save");
        this.triggerListener(event);
    }
    public void remove(){
        System.out.println("删除了一条数据");
        IEvent event = new Event(this,"remove");
        this.triggerListener(event);
    }
    public void modify(){
        System.out.println("修改了一条数据");
        IEvent event = new Event(this,"modify");
        this.triggerListener(event);
    }
    public void find(){
        System.out.println("插入了一条数据");
        IEvent event = new Event(this,"find");
        this.triggerListener(event);
    }

}
