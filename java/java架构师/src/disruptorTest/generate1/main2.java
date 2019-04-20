package generate1;

import com.lmax.disruptor.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class main2 {
    public static void main(String[] args) {
        final Integer BUFFER_SIZE = 1024;
        Integer THREAD_NUMBERS = 4;

        final RingBuffer<Trade> ringBuffer = RingBuffer.createSingleProducer(new EventFactory<Trade>() {
            @Override
            public Trade newInstance() {
                return new Trade();
            }
        }, BUFFER_SIZE, new YieldingWaitStrategy());

        //  创建线程池
        ExecutorService service = Executors.newFixedThreadPool(THREAD_NUMBERS);

        // 创建SequenceBarrier
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        // 创建消息处理器
        /*BatchEventProcessor<Trade> tradeBatchEventProcessor=new BatchEventProcessor<>(ringBuffer
                ,sequenceBarrier,new TrandeHandler());*/

        WorkHandler<Trade> handler = new TrandeHandler();

        WorkerPool<Trade> workerPool = new WorkerPool<Trade>(ringBuffer, sequenceBarrier, new IgnoreExceptionHandler(), handler);

        workerPool.start(service);
        // 这一步是把消费者的位置信息引用注入到生产者 如果只有一个消费者的情况可以省略

        for (int i = 0; i < 10; i++) {
            long seq = ringBuffer.next();
            ringBuffer.get(seq).setPrice(Math.random() * 9999);
            ringBuffer.publish(seq);
        }

        try {

            Thread.sleep(1000);
            workerPool.halt();
            service.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
