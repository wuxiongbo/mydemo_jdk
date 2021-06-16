package monitor.observe;

import monitor.observe.observable.Observable;
import monitor.observe.observe.IObserve;
import monitor.observe.observe.Observe1;
import monitor.observe.observe.Observe2;

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
        //创建多个观察者
        IObserve iObserve1 = new Observe1();
        IObserve iObserve2 = new Observe2();

        //创建被观察者
        Observable observable =new Observable();

        //被观察者添加观察者
        observable.addObserve(iObserve1);
        observable.addObserve(iObserve2);


        //被观察者向观察者发送信息
        observable.notifyObservers("GOGOGOGOGOGO");

        //删除观察者后
        observable.removeObserve(iObserve1);
        observable.notifyObservers("GO");
    }

}
