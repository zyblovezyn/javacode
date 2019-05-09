package com.mail.concurrent.UseCountDownLetch;

import java.util.concurrent.*;

public class UseFuture implements Callable<String> {
    private String para;

    public UseFuture(String para) {
        this.para = para;
    }

    /*
    这里实现业务逻辑
     */
    @Override
    public String call() throws Exception {
        //模拟执行耗时
        Thread.sleep(3 * 1000);
        String result = this.para + "处理完成";
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String queryStr1 = "query1";
        String queryStr2 = "query2";


        FutureTask<String> future1 =
                new FutureTask<>(new UseFuture(queryStr1));
        FutureTask<String> future2 =
                new FutureTask<>(new UseFuture(queryStr2));
        ExecutorService service = Executors.newFixedThreadPool(2);

        //submit和execute的区别
        // submit可以传入实现Callable接口的方法
        // submit有返回值
        Future f1 = service.submit(future1);
        Future f2 = service.submit(future2);

        /*//System.out.println(f.get());f.get()=null时处理完毕
        while (true){
            if(f.get()==null){
                System.out.println("当前任务执行完毕");
                break;
            }
        }*/
        System.out.println("请求完成！");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("数据:" + future1.get());
        System.out.println("数据:" + future2.get());

        service.shutdown();
    }
}
