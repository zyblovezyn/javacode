package tk.mybatis.simple.rabbitmqtest.ps;

import com.rabbitmq.client.*;
import tk.mybatis.simple.rabbitmq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv2 {
    private static  final  String queue_name="test_exchange_fanout_sms";

    private static  final  String exchange_name="test_exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection=ConnectionUtils.getConnection();

        Channel channel=connection.createChannel();

        channel.queueDeclare(queue_name,false,false,false,null);

        // 绑定
        channel.queueBind(queue_name,exchange_name,"");

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            // 出发消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println(msg);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(msg+ " done[2]");
                }
            }
        };

        boolean autoAck=true;
        channel.basicConsume(queue_name,autoAck,consumer);

    }
}
