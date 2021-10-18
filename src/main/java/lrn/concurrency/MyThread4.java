package lrn.concurrency;

public class MyThread4 implements Runnable {
    Thread thread;

    boolean suspended;
    boolean stopped;

    MyThread4(String name) {
        thread = new Thread(this, name);
        suspended = false;
        stopped = false;
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " starting.");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.print(i + " ");
                if (i % 10 == 0) {
                    System.out.println();
                    Thread.sleep(250);
                }

                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                    if (stopped)
                        break;
                }
            }
        } catch (InterruptedException exc) {
            System.out.println(thread.getName() + " interrupted.");
        }
        System.out.println(thread.getName() + " exiting");
    }
    synchronized void mystop() {
        stopped = true;
        suspended = false;
        notify();
    }
    synchronized void mysuspended() {
        suspended = true;
    }
    synchronized void myresume() {
        suspended = false;
        notify();
    }

    public static void main(String[] args) {
        MyThread4 ob1 = new MyThread4("My Thread");
        try {
            Thread.sleep(1000);
            ob1.mysuspended();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            ob1.myresume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);

            ob1.mysuspended();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            ob1.myresume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);

            ob1.mysuspended();
            System.out.println("stopping thread.");
            ob1.mystop();
        } catch (InterruptedException exc) {
            System.out.println("Main thread Interrupted.");
        }
        try {
            ob1.thread.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread Interrupted.");
        }

        System.out.println("Main thread exiting.");
    }
}
