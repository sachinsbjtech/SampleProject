package com.sbj.threading;

public class OddEven {

	public static void main(String[] args) {
		Object LOCK_OBJECT = new Object();
		PrintNumber printNumber = new PrintNumber(LOCK_OBJECT, 1);
		Thread t1 = new Thread(printNumber);
		Thread t2 = new Thread(printNumber);
		t1.start();
		t2.start();
	}

}
class PrintNumber implements Runnable{
	Object LOCK_OBJECT;
	Integer number;
	public PrintNumber(Object LOCK_OBJECT, Integer number) {
		this.LOCK_OBJECT = LOCK_OBJECT;
		this.number = number;
	}
	@Override
	public void run() {
		while(true) {
			synchronized (LOCK_OBJECT) {
				if(number %2 == 0) {
					System.out.println(number);
					notify();
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}{
					try {
						notify();
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(number);

				}
				number++;
			}
		}
	}
}
