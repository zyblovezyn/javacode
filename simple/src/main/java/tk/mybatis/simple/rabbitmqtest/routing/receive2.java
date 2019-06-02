package tk.mybatis.simple.rabbitmqtest.routing;

import com.rabbitmq.client.*;
import tk.mybatis.simple.rabbitmq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class receive2 {

    private static final String EXCHANGE_NAME = "test_exchange_direct";
    private static final String QUEUENAME = "test_exchange_direct";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();

        final Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUENAME,false,false,false,null);

        channel.basicQos(1);

        channel.queueBind(QUEUENAME,EXCHANGE_NAME,"error");

        channel.queueBind(QUEUENAME,EXCHANGE_NAME,"info");

        channel.queueBind(QUEUENAME,EXCHANGE_NAME,"warning");

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            // 出发消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("[2] recv msg:"+msg);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(msg+ "[2] done ");
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };

        boolean autoAck=true;
        channel.basicConsume(QUEUENAME,autoAck,consumer);

    }
}
