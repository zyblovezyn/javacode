package tk.mybatis.simple.rabbitmqtest.work;

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

        //
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        for (int i = 0; i < 50; i++) {
            String msg = "i " + i;
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            Thread.sleep(i * 10);
        }
        channel.close();
        ;
        connection.close();


    }
}
