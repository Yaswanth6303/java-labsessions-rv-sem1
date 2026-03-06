package fastProducer;

class SharedBuffer {
	private final int[] buffer;
	private int count = 0;
	private int in = 0;
	private int out = 0;

	private boolean productionCompleted = false;

	SharedBuffer(int size) {
		buffer = new int[size];
	}

	// Producer
	public synchronized void produce(int value) {
		try {
			while (count == buffer.length) {
				wait();
			}

			buffer[in] = value;
			in = (in + 1) % buffer.length;
			count++;

			System.out.println(Thread.currentThread().getName() + " produced: " + value);

			notifyAll();

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	// Producer signals completion
	public synchronized void markProductionComplete() {
		productionCompleted = true;
		notifyAll(); // wake all consumers
	}

	// Consumer
	public synchronized boolean consume() {
		try {
			while (count == 0 && !productionCompleted) {
				System.out.println(Thread.currentThread().getName() + " waiting (Production not finished)");
				wait();
			}

			if (count == 0 && productionCompleted) {
				return false;
			}

			int value = buffer[out];
			out = (out + 1) % buffer.length;
			count--;

			System.out.println(Thread.currentThread().getName() + " consumed: " + value);

			notifyAll();
			return true;

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return false;
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
		for (int i = 1; i <= 7; i++) {
			buffer.produce(i);
		}

		System.out.println("Producer finished production");
		buffer.markProductionComplete();
	}
}

class Consumer extends Thread {
	private final SharedBuffer buffer;

	Consumer(SharedBuffer buffer, String name) {
		super(name);
		this.buffer = buffer;
	}

	public void run() {
		while (buffer.consume()) {

		}
		System.out.println(Thread.currentThread().getName() + " exiting (no more items)");
	}
}

public class ProducerConsumer {
	public static void main(String[] args) {

		SharedBuffer buffer = new SharedBuffer(5);

		Producer producer = new Producer(buffer, "Producer");

		Consumer consumer1 = new Consumer(buffer, "Consumer-1");
		Consumer consumer2 = new Consumer(buffer, "Consumer-2");

		producer.start();
		consumer1.start();
		consumer2.start();
	}
}
