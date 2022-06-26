package com.sbj;

public class ConcurrancyTest {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t1 = new Thread(mt);
		Thread t2 = new Thread(mt);
		Thread t3 = new Thread(mt);
		
		
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}

class MyThread implements Runnable{
	int counter = 0 ;

	public MyThread() {
	}
	@Override
	public void run() {
		while(true) {
			try {
				synchronized (this) {


					if((counter % 3) == 0) {
						System.out.println("T1");
					} else if((counter % 3) == 1) {
						System.out.println("T2");
					}else if((counter % 3) == 2) {
						System.out.println("T3");
					}
					counter++;
					Thread.sleep(2000);
					this.notify();
					this.wait();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
