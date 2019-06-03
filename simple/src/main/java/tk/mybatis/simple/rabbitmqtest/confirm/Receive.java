package tk.mybatis.simple.rabbitmqtest.confirm;

import com.rabbitmq.client.*;
import tk.mybatis.simple.rabbitmq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive {
    private static final String QUEUE_NAME = "test_queue_confirm1";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String s = channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                System.out.println("receive [confirm] msg:" + new String(body));
            }
        });
    }
}
