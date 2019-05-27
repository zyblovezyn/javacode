package tk.mybatis.simple.rabbitmqtest;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import tk.mybatis.simple.rabbitmq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Produce {

    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = null;
        Channel channel = null;
        try {
            connection = ConnectionUtils.getConnection();

            //获取通道
            channel = connection.createChannel();

            //创建队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            String msg = "hello simple";

            channel.basicPublish("",QUEUE_NAME,  null, msg.getBytes());

            System.out.println("----send msg: " + msg);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (channel != null)
                channel.close();
            if (connection != null)
                connection.close();
        }

    }

}
