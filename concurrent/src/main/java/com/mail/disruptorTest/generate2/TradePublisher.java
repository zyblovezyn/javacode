package com.mail.disruptorTest.generate2;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TradePublisher implements Runnable {

    Disruptor<Trade> disruptor;
    private CountDownLatch letch;
    private static int LOOP = 10;

    public TradePublisher(CountDownLatch letch, Disruptor<Trade> disruptor) {
        this.letch = letch;
        this.disruptor = disruptor;
    }

    @Override
    public void run() {
        TradeEventTranslator tradeEventTranslator =
                new TradeEventTranslator();
        for (int i = 0; i < LOOP; i++) {
            disruptor.publishEvent(tradeEventTranslator);
        }
        letch.countDown();
    }
}

class TradeEventTranslator implements EventTranslator<Trade> {
    private Random random = new Random();

    @Override
    public void translateTo(Trade event, long sequence) {
        this.generateTrade(event);
    }

    private Trade generateTrade(Trade trade) {
        trade.setPrice(random.nextDouble() * 9999);
        return trade;
    }
}
