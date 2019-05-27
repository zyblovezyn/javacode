package tk.mybatis.simple.rabbitmqtest.work;

import com.rabbitmq.client.*;
import tk.mybatis.simple.rabbitmq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Rev2 {
    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            // 出发消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("[2] "+msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(msg+ "[2] done");
                }
            }
        };

        boolean autoAck=true;
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);
    }
}
