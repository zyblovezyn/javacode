package tk.mybatis.simple.rabbitmqtest;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import tk.mybatis.simple.rabbitmq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive {
    private static final String QUEUE_NAME = "test_simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection=ConnectionUtils.getConnection();

        Channel channel=connection.createChannel();

        channel.

    }
}
