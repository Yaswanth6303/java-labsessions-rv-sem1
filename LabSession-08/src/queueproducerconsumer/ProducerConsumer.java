package queueproducerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread {
	private final BlockingQueue<Integer> queue;

	Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
		setName("Producer");
	}

	@Override
	public void run() {
		int value = 1;
		try {
			while (value <= 10) {

				// Check buffer full state
				if (queue.remainingCapacity() == 0) {
					System.out.println(getName() + " waiting (Buffer FULL)");
				}

				queue.put(value); // blocks automatically
				System.out.println(getName() + " produced: " + value);

				value++;
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

class Consumer extends Thread {
	private final BlockingQueue<Integer> queue;

	Consumer(BlockingQueue<Integer> queue, String name) {
		super(name);
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {

				// Check buffer empty state
				if (queue.isEmpty()) {
					System.out.println(getName() + " waiting (Buffer EMPTY)");
				}

				int value = queue.take(); // blocks automatically
				System.out.println(getName() + " consumed: " + value);

				Thread.sleep(800);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

public class ProducerConsumer {
	public static void main(String[] args) {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

		Producer producer = new Producer(queue);
		Consumer consumer1 = new Consumer(queue, "Consumer-1");
		Consumer consumer2 = new Consumer(queue, "Consumer-2");

		producer.start();
		consumer1.start();
		consumer2.start();
	}
}