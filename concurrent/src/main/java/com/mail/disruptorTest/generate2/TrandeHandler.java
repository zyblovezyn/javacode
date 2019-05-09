package com.mail.disruptorTest.generate2;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

import java.util.UUID;

public class TrandeHandler implements EventHandler<Trade>, WorkHandler<Trade> {
    @Override
    public void onEvent(Trade trade, long l, boolean b) throws Exception {
        this.onEvent(trade);
    }

    @Override
    public void onEvent(Trade trade) throws Exception {
        trade.setId(UUID.randomUUID().toString());
        System.out.println(trade.getId());
    }
}
