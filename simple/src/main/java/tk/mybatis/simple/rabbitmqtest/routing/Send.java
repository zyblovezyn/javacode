package tk.mybatis.simple.rabbitmqtest.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import tk.mybatis.simple.rabbitmq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private static final String EXCHANGE_NAME="test_exchange_direct";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection=ConnectionUtils.getConnection();

        Channel channel=connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"direct");

        String msg="hello direct";

        System.out.println("send:"+msg);
        String routingKry="error";
        channel.basicPublish(EXCHANGE_NAME,routingKry,null,msg.getBytes());;

        channel.close();
        connection.close();
    }
}
