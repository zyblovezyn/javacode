package tk.mybatis.simple.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtils {

    /**
     * 获取mq的连接
     */

    public static Connection getConnection() throws IOException, TimeoutException {

        ConnectionFactory factory=new ConnectionFactory();

        // 连接信息
        factory.setHost("192.168.209.129");

        factory.setPort(5672);

        factory.setVirtualHost("/vhost_mmr");

        factory.setUsername("user_mmr");

        factory.setPassword("123");

        return factory.newConnection();
    }


}
