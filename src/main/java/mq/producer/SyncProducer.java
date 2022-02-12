package mq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 同步发送者
 *
 *
 * 消息发送者的固定步骤
 *
 * 1.创建  消息生产者producer，并制定生产者组名
 * 2.指定Nameserver地址
 * 3.启动producer
 * 4.创建消息对象，指定主题Topic、Tag和消息体
 * 5.发送消息
 * 6.关闭生产者producer
 *
 *
 */
public class SyncProducer {

    public static void main(String[] args) throws Exception {
        // 实例化消息生产者，并指定组名
        DefaultMQProducer producer = new DefaultMQProducer("first_group");

        producer.setNamesrvAddr("localhost:9876");

        // 生产者启动
        producer.start();






        // 循环发送100条消息
        for (int i = 0; i < 100; i++) {

            // 创建消息实例，设置Topic , Tag , 消息内容 body
            Message msg = new Message(
                    "TopicTest" ,
                    "TagA" ,
                    ("Hello RocketMQ wxb" + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* 消息内容主体 */
            );


            // 消息发送，并且获取返回结果
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }



        // 发送消息完成，关闭生产者
        producer.shutdown();
    }

}

