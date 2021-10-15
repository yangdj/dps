package lrn.concurrency;

public class MyThread3 implements Runnable {
    Thread thread;
    TickTock ttOb;

    MyThread3(String name, TickTock tt) {
        thread = new Thread(this, name);
        ttOb = tt;
        thread.start();
    }

    @Override
    public void run() {
        if (thread.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++)
                ttOb.tick(true);
            ttOb.tick(false);
        } else {
            for (int i = 0; i < 5; i++)
                ttOb.tock(true);
            ttOb.tock(false);
        }
    }

    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThread3 mt1 = new MyThread3("Tick", tt);
        MyThread3 mt2 = new MyThread3("Tock", tt);
        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Finished.");
    }
}
