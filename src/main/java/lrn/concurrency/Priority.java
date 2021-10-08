package lrn.concurrency;

public class Priority implements Runnable {
    int count;
    Thread thread;
    static boolean stop = false;
    static String currentName;
    static int switches = 0;

    Priority(String name) {
        thread = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " starting.");
        do {
            count++;
            if(currentName.compareTo(thread.getName()) != 0) {
                currentName = thread.getName();
                System.out.println("In " + currentName);
                switches++;
            }
        } while (!stop && count < 10000000);
        stop = true;
        System.out.println("\n" + thread.getName() + " terminating.");
    }

    public static void main(String[] args) {
        Priority mt1 = new Priority("High Priority");
        Priority mt2 = new Priority("Low Priority");
        mt1.thread.setPriority(Thread.NORM_PRIORITY + 1);
        mt2.thread.setPriority(Thread.NORM_PRIORITY - 1);

        mt1.thread.start();
        mt2.thread.start();

        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nHigh priority thread counted to " + mt1.count);
        System.out.println("\nLow priority thread counted to " + mt2.count);
        System.out.println("\nTotal switches: " + Priority.switches);
    }
}
