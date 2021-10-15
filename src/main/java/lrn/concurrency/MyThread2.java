package lrn.concurrency;

public class MyThread2 implements Runnable {
    Thread thread;
    static SumArray sa = new SumArray();
    int[] a;
    int answer;

    MyThread2(String name, int[] nums) {
        thread = new Thread(this, name);
        a = nums;
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " Starting.");
        answer = sa.sumArray(a);
        System.out.println("Sum for " + thread.getName() + " is " + answer);
        System.out.println(thread.getName() + " terminating.");
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        MyThread2 mt1 = new MyThread2("Child #1", a);
        MyThread2 mt2 = new MyThread2("Child #2", a);

        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted");
        }
    }
}
