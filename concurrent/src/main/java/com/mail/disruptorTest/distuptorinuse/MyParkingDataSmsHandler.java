package com.mail.disruptorTest.distuptorinuse;

import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;


/**
 * 第三个消费者，sms短信服务，告知司机你已经进入停车场，计费开始。
 */


@Slf4j
public class MyParkingDataSmsHandler implements EventHandler<MyInParkingDataEvent> {
    @Override
    public void onEvent(MyInParkingDataEvent event, long sequence, boolean endOfBatch) throws Exception {
        long threadId = Thread.currentThread().getId();

        String carLicense = event.getCarLicense();

        log.info("Thread Id {} 给  {} 的车主发送一条短信，并告知他计费开始了 ....", threadId, carLicense);
    }
}
