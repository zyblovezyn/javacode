package tk.mybatis.simple.rabbitmqtest.transtation;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.impl.ChannelN;
import tk.mybatis.simple.rabbitmq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

// 消息事务
public class TxSend {

    private static final String QUEUE_NAME = "test_queue_tx";

    public static void main(String[] args) throws IOException, TimeoutException {


        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String msg = "hello tx messgae";

        try {
            channel.txSelect();

            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());

            channel.txCommit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.txRollback();
        }
        channel.close();
        connection.close();
    }
}
