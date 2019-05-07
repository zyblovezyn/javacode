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

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, ringBufferSize, executorService, ProducerType.SINGLE, new YieldingWaitStrategy());

        // 连接消费事件方法
        disruptor.handleEventsWith(new LongEventHandle());

        disruptor.start();

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
