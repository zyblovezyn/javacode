package com.mail.disruptorTest.distuptorinuse;


import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;


/**
 * 第二个消费者，负责发送通知告知工作人员(Kafka是一种高吞吐量的分布式发布订阅消息系统)
 */



@Slf4j
public class MyParkingDataToKafkaHandler implements EventHandler<MyInParkingDataEvent> {
    @Override
    public void onEvent(MyInParkingDataEvent event, long sequence, boolean endOfBatch) throws Exception {
        long threadId=Thread.currentThread().getId();
        String carLicense=event.getCarLicense();
        log.info("Thread Id {} 发送 {} 进入停车场信息给 kafka系统...", threadId, carLicense);

    }
}
