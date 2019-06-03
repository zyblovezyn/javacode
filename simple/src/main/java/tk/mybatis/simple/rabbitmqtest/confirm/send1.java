package tk.mybatis.simple.rabbitmqtest.confirm;

import com.rabbitmq.client.*;
import tk.mybatis.simple.rabbitmq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 普通模式
 */
public class send1 {
    private static final String QUEUE_NAME = "test_queue_confirm1";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);


        // 生产调用  将channel设置configrm模式
        channel.confirmSelect();

        String msg = "hello confirm";
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        }

        if (!channel.waitForConfirms()) {
            System.out.println("msg send failed");
        } else {
            System.out.println("ok! ");
        }
        channel.close();
        connection.close();
    }
}
