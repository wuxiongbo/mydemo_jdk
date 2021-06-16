package monitor.observe.observable;

import monitor.observe.observe.IObserve;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>被观察者实现类</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/16
 * </pre>
 */
public class Observable implements IObservable{
    // 由于一个被观察者可以被多个观察者所观察，所以要设置一个观察者链表里
    private List<IObserve> observes;

    public Observable(){
        //在被观察者对象被创建时，就将集合初始化
        observes = new ArrayList<>();
    }

    @Override
    public void addObserve(IObserve observe) {
        observes.add(observe);
    }
    @Override
    public void removeObserve(IObserve observe) {
        observes.remove(observe);
    }
    @Override
    public void notifyObservers(String message) {
        for (IObserve observe : observes) {
            observe.handleNotify(message);
        }
    }
}
