package disruptorTest.base;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class LongEventProducer {

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer){
        this.ringBuffer=ringBuffer;
    }

    /*
    onData用来发布事件 每调用一次就发布一次事件
    它的参数通过事件传递给消费者
     */
    public void onData(ByteBuffer bb){
        long sequeue=ringBuffer.next();
        try{
            LongEvent event=ringBuffer.get(sequeue);
            event.setValue(bb.getLong(0));
        }finally {
            ringBuffer.publish(sequeue);
        }
    }
}
