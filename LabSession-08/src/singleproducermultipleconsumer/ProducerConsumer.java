package singleproducermultipleconsumer;

class SharedBuffer {
	private final int[] buffer;
	private int count = 0;
	private int in = 0;
	private int out = 0;

	SharedBuffer(int size) {
		buffer = new int[size];
	}

	public synchronized void produce(int value) {
		try {
			while (count == buffer.length) {
				System.out.println(Thread.currentThread().getName() + " waiting (Buffer FULL)");
				wait();

				buffer[in] = value;
				in = (in + 1) % buffer.length;
				count++;

				System.out.println(Thread.currentThread().getName() + " produced: " + value);

				notifyAll();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public synchronized void consume() {
		try {
			while (count == 0) {
				System.out.println(Thread.currentThread().getName() + " waiting (Buffer EMPTY)");
				wait();
			}

			int value = buffer[out];
			out = (out + 1) % buffer.length;
			count--;

			System.out.println(Thread.currentThread().getName() + " consumed: " + value);

			notifyAll();

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

class Producer extends Thread {
	private final SharedBuffer buffer;

	Producer(SharedBuffer buffer, String name) {
		super(name);
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 1; i <= 8; i++) {
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

	Consumer(SharedBuffer buffer, String name) {
		super(name);
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 1; i <= 4; i++) {
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

		SharedBuffer buffer = new SharedBuffer(10);

		Producer producer = new Producer(buffer, "Producer");

		Consumer consumer1 = new Consumer(buffer, "Consumer-1");
		Consumer consumer2 = new Consumer(buffer, "Consumer-2");

		producer.start();
		consumer1.start();
		consumer2.start();
	}
}
