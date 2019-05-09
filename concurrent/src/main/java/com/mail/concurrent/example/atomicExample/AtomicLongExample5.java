package com.mail.concurrent.example.atomicExample;

import com.mail.concurrent.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
@Slf4j
public class AtomicLongExample5 {

    private static AtomicIntegerFieldUpdater<AtomicLongExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicLongExample5.class, "count");

    @Getter
    public volatile int count = 100;


    public static void main(String[] args) {
        AtomicLongExample5 example5 = new AtomicLongExample5();
        if (updater.compareAndSet(example5, 100, 120))
            log.info("update success 1 count:{}", example5.getCount());
        if (updater.compareAndSet(example5, 100, 120))
            log.info("update success 2 count:{}", example5.getCount());
        else
            log.info("update failed count {}",example5.getCount());
    }
}
