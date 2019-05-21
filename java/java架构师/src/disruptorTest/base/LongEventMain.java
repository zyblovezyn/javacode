import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LongEventMain {
    public static void main(String[] args) {

        // 创建缓冲池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 创建工厂
        LongEventFactory factory = new LongEventFactory();

        // 创建buffersize 也就是RingBuffer大小，必须是2的N次方
        int ringBufferSize = 1024 * 1024;

        //BlockingWaitStrategy 是最低效的策略，但对CPU消耗最小并且在各种不同部署环境中能提供更加一致的性能表现
        //WaiteStrategy BLOCK_WAIT=new BlockWaitStategy

        // SleepWaitStrategy 效率和CPU消耗与BlockingWaitStrategy差不多，但对生产者线程影响较小，适合用于异步日志类似的场景
        // YieldingWaitStrategy 的性能最好，适合用于低延迟的系统，在要求极高性能且事件处理线程数小于CPU逻辑核心数的场景中，推荐使用此策略
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(
            factory,                    //工厂类对象
            ringBufferSize,             //缓冲区大小
            executorService,            // 线程池
            ProducerType.SINGLE,        // SINGLE和MULTI
            new YieldingWaitStrategy()  //等待策略
        );

        // 连接消费事件方法
        disruptor.handleEventsWith(new LongEventHandle());

        disruptor.start();

        //发布事件 或者理解成数据具体存放的容器
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        //LongEventProducer producer= new LongEventProducer(ringBuffer);
        LongEventProducerWithTranslator producer = new LongEventProducerWithTranslator(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (long a = 0; a < 100; a++) {
            byteBuffer.putLong(0, a);
            producer.onData(byteBuffer);
        }

        disruptor.shutdown();
        executorService.shutdown();
    }
}
