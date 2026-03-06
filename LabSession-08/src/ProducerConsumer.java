class SharedBuffer {
    private final int[] buffer;
    private int size;
    private int in;
    private int out;

    SharedBuffer(int n) {
        this.buffer = new int[n];
        this.size = 0;
        this.in = 0;
        this.out = 0;
    }

    public synchronized void produce(int value) {
        try {
            while (size == buffer.length) {
                System.out.println(Thread.currentThread().getName() + " waiting (Buffer FULL)");
                wait();
            }

            buffer[in] = value;
            in = (in + 1) % buffer.length;
            size++;
            System.out.println(Thread.currentThread().getName() + " produced " + value);
            notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void consume() {
        try {
            while (size == 0) {
                System.out.println(Thread.currentThread().getName() + " waiting (Buffer EMPTY)");
                wait();
            }

            int value = buffer[out];
            out = (out + 1) % buffer.length;
            size--;
            System.out.println(Thread.currentThread().getName() + " consumed " + value);
            notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


class Producer extends Thread {
    private final SharedBuffer buffer;

    Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer extends Thread {
    private final SharedBuffer buffer;

    Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.consume();
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5);

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}