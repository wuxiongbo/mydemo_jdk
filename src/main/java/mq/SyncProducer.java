package mq;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/23
 * </pre>
 */

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 同步发送者
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
                    ("Hello RocketMQ lzx" + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* 消息内容主体 */
            );
            // 消息发送，并且获取返回结果
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }

        // 发送消息完成，关闭生产者
        producer.shutdown();
    }

}

