package com.mail.disruptorTest.distuptorinuse;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Handler 第一个消费者，负责保存进场汽车的信息
 *
 */

@Slf4j
public class MyParkingDataInDbHandler implements EventHandler<MyInParkingDataEvent>,
        WorkHandler<MyInParkingDataEvent> {
    @Override
    public void onEvent(MyInParkingDataEvent myInParkingDataEvent, long l, boolean b) throws Exception {
        long threadId=Thread.currentThread().getId(); //当前线程ID

        String carLicense=myInParkingDataEvent.getCarLicense(); // 获取车牌

        log.info("Thread ID:{} 保存 {} 到数据库",threadId,carLicense);
    }

    @Override
    public void onEvent(MyInParkingDataEvent myInParkingDataEvent) throws Exception {
        this.onEvent(myInParkingDataEvent);
    }
}
