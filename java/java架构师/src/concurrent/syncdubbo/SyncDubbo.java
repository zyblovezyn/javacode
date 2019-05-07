package concurrent.syncdubbo;

public class SyncDubbo {

    public synchronized void m1() {
        System.out.println("m1 start ...");
        m2();
    }

    public synchronized void m2() {
        System.out.println("m2 start ...");
        m3();
    }

    public synchronized void m3() {
        System.out.println("m3 start ...");
    }

    public static void main(String[] args) {
        final SyncDubbo syncDubbo = new SyncDubbo();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncDubbo.m1();
            }
        });

        t1.start();
    }

}
