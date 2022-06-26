package com.sbj.threading;

public class PingPong {
	public static void main(String[] args) {
		MyThread myThread = new MyThread("");
		Thread ping  = new Thread(myThread);
		Thread pong  = new Thread(myThread);
		ping.start();
		pong.start();
		 System.out.println(System.getProperty("java.vendor","unknown"));
	}
}

class MyThread implements Runnable{
	private String text = "";
	private int i = 0;
	public MyThread(String text) {
		this.text = text;
	}

	@Override
	public void run() {
		System.out.println("Started...........");
		synchronized (this) {
			while(true) {
				try {
					Thread.sleep(50);
					if(i % 2 ==0) {
						System.out.println("Ping ************");
					}else {
						System.out.println("Pong");
					}
					i++;
					notify();
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
