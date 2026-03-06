package multipleproducerconsumer;

class SharedBuffer {
	private int number;
	private boolean available = false;

	public synchronized void produce(int value) {
		try {
			while (available) {
				System.out.println(Thread.currentThread().getName() + " WAITING (buffer full)");
				wait();
			}

			number = value;
			available = true;
			System.out.println(Thread.currentThread().getName() + " PRODUCED: " + number);

			notifyAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized int consume() {
		int result = 0;
		try {
			while (!available) {
				System.out.println(Thread.currentThread().getName() + " WAITING (buffer empty)");
				wait();
			}

			result = number;
			available = false;
			System.out.println(Thread.currentThread().getName() + " CONSUMED: " + result);

			notifyAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return result;
	}
}

class Producer extends Thread {
	SharedBuffer buffer;

	Producer(SharedBuffer buffer, String name) {
		super(name);
		this.buffer = buffer;
	}

	public void run() {
		System.out.println(getName() + " STARTED");
		for (int i = 0; i < 5; i++) {
			buffer.produce(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(getName() + " TERMINATED");
	}
}

class Consumer extends Thread {
	SharedBuffer buffer;

	Consumer(SharedBuffer buffer, String name) {
		super(name);
		this.buffer = buffer;
	}

	public void run() {
		System.out.println(getName() + " STARTED");
		for (int i = 0; i < 5; i++) {
			buffer.consume();

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(getName() + " TERMINATED");
	}
}

public class MultipleProducerConsumer {
	public static void main(String[] args) {
		System.out.println("MAIN THREAD STARTED");

		SharedBuffer buffer = new SharedBuffer();

		Producer p1 = new Producer(buffer, "Producer-1");
		Producer p2 = new Producer(buffer, "Producer-2");

		Consumer c1 = new Consumer(buffer, "Consumer-1");
		Consumer c2 = new Consumer(buffer, "Consumer-2");

		p1.start();
		c1.start();
		p2.start();
		c2.start();

		try {
			Thread.sleep(2000);
			System.out.println("MAIN THREAD SLEEPING");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("MAIN THREAD TERMINATED");
	}
}
