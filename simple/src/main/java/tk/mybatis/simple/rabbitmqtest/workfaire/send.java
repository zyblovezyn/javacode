package tk.mybatis.simple.rabbitmqtest.workfaire;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import tk.mybatis.simple.rabbitmq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class send {
    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        // 获取连接
        Connection connection = ConnectionUtils.getConnection();

        // 获取channel
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        /*
        每个消费者在确认之前 消息队列不发生下一个消息到消费
        一次只处理一个消息

        限制发生给同一消费者 不得超过一条
         */
        channel.basicQos(1);

        for (int i = 0; i < 50; i++) {
            String msg = "i " + i;
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            Thread.sleep(i * 10);
        }
        channel.close();

        connection.close();


    }
}
