package concurrent.masterworker;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Master master = new Master(new MyWorker(), 2 * Runtime.getRuntime().availableProcessors());
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            Task t = new Task();
            t.setId(i);
            t.setName("任务" + i);
            t.setPrice(random.nextInt(1000));
            master.submit(t);
        }
        master.execute();

        long start = System.currentTimeMillis();
        while (true) {
            if (master.isComplete()) {
                long end = System.currentTimeMillis();
                Integer result = master.getResult();
                System.out.println(result + "  " + Runtime.getRuntime().availableProcessors());
                System.out.println((end - start));
                break;
            }
        }
    }

        /*Random r = new Random();
        System.out.println(r.nextInt(1000));*/

}
