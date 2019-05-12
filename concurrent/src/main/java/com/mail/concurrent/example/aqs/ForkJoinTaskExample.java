package com.mail.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

@Slf4j
public class ForkJoinTaskExample extends RecursiveTask<Integer> {

    public static final int threshold = 2;
    private int start;
    private int end;

    public ForkJoinTaskExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= threshold;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            ForkJoinTaskExample left = new ForkJoinTaskExample(start, middle);
            ForkJoinTaskExample right = new ForkJoinTaskExample(middle + 1, end);

            //执行子任务
            left.fork();
            right.fork();

            //等待任务结束合并结果
            int leftResult = left.join();
            int rightResult = right.join();

            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务 计算1+2+3+4
        ForkJoinTaskExample task = new ForkJoinTaskExample(0, 100);
        //执行任务
        Future<Integer> integerFuture = forkJoinPool.submit(task);

        try {
            log.info("result:{}", integerFuture.get());
        } catch (Exception e) {
            log.error("exception", e);
        }
    }
}
