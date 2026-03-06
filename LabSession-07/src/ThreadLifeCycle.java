class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread1 State after start(): " + this.getState());

        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println("Thread1 Running → " + i);
                Thread.sleep(2000);
                System.out.println("Thread1 woke up from sleep.");

                System.out.println("Thread1 yielding...");
                Thread.yield();

            } catch (InterruptedException e) {
                System.out.println("Thread1 Interrupted");
            }
        }

        System.out.println("Thread1 Completed.");
    }
}

class Thread2 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread2 State after start(): " + this.getState());

        for (int i = 10; i <= 15; i++) {
            try {
                System.out.println("Thread2 Running → " + i);
                Thread.sleep(2000); 
                System.out.println("Thread2 woke up from sleep.");

                System.out.println("Thread2 yielding...");
                Thread.yield();

            } catch (InterruptedException e) {
                System.out.println("Thread2 Interrupted");
            }
        }

        System.out.println("Thread2 Completed.");
    }
}

public class ThreadLifeCycle {

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        System.out.println("Initial State of Thread1: " + t1.getState());
        System.out.println("Initial State of Thread2: " + t2.getState());

        t1.start();
        t2.start();

        System.out.println("\nMain Thread Completed.");
    }
}
