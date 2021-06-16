package monitor.event_jdk;

/**
 * <p>测试</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/16
 * </pre>
 */
public class Test {
    public static void main(String[] args) {
        //定义 事件源（被观察者）
        EventSource eventSource = new EventSource();

        //定义 监听器（观察者）
        Listener windowsListener= event -> {
            event.doEvent();

            //处理感兴趣的事件
            if(event.getSource().equals("openWindows")) {
                System.out.println("侦听到openWindows事件，do Open");
            }
            if(event.getSource().equals("closeWindows")){
                System.out.println("侦听到openWindows事件，do Close");
            }

        };

        //注册 监听器
        eventSource.addListener(windowsListener);


        /* 触发事件：
         * 传入openWindows事件，通知所有的事件监听器
         * 对open事件感兴趣的listener将会执行
         */
        eventSource.notifyListenerEvents(
                //
                new PrintEvent("openWindows")
        );





        // 定义 事件源（被观察者）
        // 对特定的事件提供特定的关注方法和事件触发
        // 关注关闭事件，实现回调接口
        EventSource windows = new EventSource();

        // 定义 监听器（观察者）。监听关闭窗口事件
        Listener closeWindowsListener = event -> {
            event.doEvent();
            // 处理感兴趣的事件。 当前监听器，只对关窗事件感兴趣
            if (event.getSource().equals("closeWindows")) {
                System.out.println("，并执行成功closeWindows");
            }
        };

        //注册 监听器。 具体这里是 调用addCloseWindowListener方法，关注 关闭窗口事件
        windows.addCloseWindowListener(closeWindowsListener);


        //事件源 触发 窗口关闭动作。
        windows.doCloseWindows();

        //到了这里，是不是 类似按钮注册监听器，然后点击触发点击事件，执行监听器中对应事件的动作

    }
}

/*
    result:
    通知一个事件源 source: openWindows
    doOpen
    这就是事件监听模式
    回调接口类: MonitorListener
    回调函数接口: handleEvent
    通过回调模型，EventSource事件源便可回调具体监听器动作
*/
