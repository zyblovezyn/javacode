package tk.mybatis.simple.rabbitmqtest.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import tk.mybatis.simple.rabbitmq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class send {

    private static final String EXCHANG_NAME="test_exchange_topic";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection=ConnectionUtils.getConnection();

        Channel channel=connection.createChannel();

        channel.exchangeDeclare(EXCHANG_NAME,"topic");

        String msg="商品....";

        channel.basicPublish(EXCHANG_NAME,"goods.delete",null,msg.getBytes());

        System.out.println("---------send----------"+msg);

        channel.close();
        connection.close();
    }
}
