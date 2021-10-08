package mq;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/23
 * </pre>
 */

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 消费者
 */
public class Consumer {

    public static void main(String[] args) throws Exception{
        // 实例化一个消息消费者，并指定组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_consumer");
        // 设置名称服务器地址
        consumer.setNamesrvAddr("localhost:9876");
        // 设置订阅topic 以及 tag
        consumer.subscribe("scheduleMsg", "*");
        // 设置消息监听
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            /**
             * 消费消息
             * @param msgs
             * @param context
             * @return
             */
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                // 打印当前是哪个现场消费的消息
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(),msgs);
                System.out.println();
                msgs.forEach(messageExt -> {
                    // 消费消息
                    System.out.println(new String(messageExt.getBody()));
                });
                // 返回消息状态
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 消费者启动
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }

}
