package mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 消费者
 *
 *
 * 消息消费者的固定步骤
 *
 * 1.创建消费者Consumer，制定消费者组名
 * 2.指定Nameserver地址
 * 3.订阅主题Topic和Tag
 * 4.设置回调函数，处理消息
 * 5.启动消费者consumer
 *
 *
 */
public class Consumer {

    public static void main(String[] args) throws Exception{


        // 实例化一个消息消费者，并指定组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_consumer");
        // 设置名称服务器地址
        consumer.setNamesrvAddr("localhost:9876");
        // 设置订阅topic 以及 tag
        consumer.subscribe("TopicTest", "*");





        // 设置消息监听
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            /**
             * 回调函数
             * 处理消费消息
             * @param msgs
             * @param context
             * @return
             */
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,ConsumeConcurrentlyContext context) {
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
