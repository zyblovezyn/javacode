package tk.mybatis.simple.rabbitmqtest.ps;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import tk.mybatis.simple.rabbitmq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class send {
    private static  final  String exchange_name="test_exchange_fanout";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection=ConnectionUtils.getConnection();

        Channel channel=connection.createChannel();

        // 声明交换机
        channel.exchangeDeclare(exchange_name,"fanout");

        // 发送消息
        String msg="hello ps";

        channel.basicPublish(exchange_name,"",null,msg.getBytes());;
        System.out.println("send :"+msg);

        channel.close();
        connection.close();

    }
}
