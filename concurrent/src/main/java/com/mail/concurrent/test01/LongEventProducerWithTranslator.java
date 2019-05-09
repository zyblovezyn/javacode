
package com.mail.concurrent.test01;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.mail.disruptorTest.base.LongEvent;

import java.nio.ByteBuffer;

public class LongEventProducerWithTranslator {

    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR_ONE_ARG
            = new EventTranslatorOneArg<LongEvent, ByteBuffer>() {
        @Override
        public void translateTo(LongEvent longEvent, long l, ByteBuffer byteBuffer) {
            longEvent.setValue(byteBuffer.getLong(0));
        }
    };

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer buffer) {
        ringBuffer.publishEvent(TRANSLATOR_ONE_ARG, buffer);
    }
}

