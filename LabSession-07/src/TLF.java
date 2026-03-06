class MyThread extends Thread {
	static final Object lock = new Object();
	private final int type;
	
	public MyThread(int type) {
		this.type = type;
	}
	
	@Override
	public void run() {
		try {
			if (type == 1) {
				Thread.sleep(2000);
			} else if (type == 2) {
				synchronized (lock) {
					lock.wait();
				}
			} else if (type == 3) {
				synchronized (lock) {
					System.out.println("Thread entered into synchronised block");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class TLF {
	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread(1);
		System.out.println(t1.getState());
		t1.start();
		System.out.println(t1.getState());
		Thread.sleep(200);
		System.out.println(t1.getState());
		
		MyThread t2 = new MyThread(2);
		t2.start();
		Thread.sleep(200);
		System.out.println(t2.getState());
		
		MyThread t3 = new MyThread(3);
		
		synchronized (MyThread.lock) {
			t3.start();
			Thread.sleep(200);
			System.out.println(t3.getState());
		}
		
		synchronized (MyThread.lock) {
			MyThread.lock.notify();
		}
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		System.out.println(t3.getState());
	}
}