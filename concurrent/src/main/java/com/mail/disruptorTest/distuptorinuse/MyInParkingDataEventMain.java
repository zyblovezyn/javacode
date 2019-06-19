package com.mail.disruptorTest.distuptorinuse;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyInParkingDataEventMain {
    public static void main(String[] args) {

        long beginTime = System.currentTimeMillis();

        int bufferSize = 1024 * 2; // 2的N次方

        try {

            ExecutorService executorService = Executors.newFixedThreadPool(4);

            // 初始化一个 Disruptor

            Disruptor<MyInParkingDataEvent> disruptor = new Disruptor<>(
                    new EventFactory<MyInParkingDataEvent>() {
                        @Override
                        public MyInParkingDataEvent newInstance() {
                            return new MyInParkingDataEvent();
                        }
                    }, bufferSize, executorService, ProducerType.SINGLE, new YieldingWaitStrategy());

            // 使用disruptor创建消费者组 MyParkingDataInDbHandler 和 MyParkingDataToKafkaHandler
            EventHandlerGroup<MyInParkingDataEvent> group = disruptor.handleEventsWith(
                    new MyParkingDataInDbHandler(), new MyParkingDataToKafkaHandler()
            );

            // 当上面两个消费者处理结束后在消耗 smsHandler
            MyParkingDataSmsHandler myParkingDataSmsHandler = new MyParkingDataSmsHandler();

            group.then(myParkingDataSmsHandler);


            //启动disruptor
            disruptor.start();

            CountDownLatch countDownLatch=new CountDownLatch(1);


            // 生产者生产数据
            executorService.submit(new MyInParkingDataEventPublisher(countDownLatch,disruptor));
            countDownLatch.await();

//            disruptor.shutdown();
//            executorService.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
