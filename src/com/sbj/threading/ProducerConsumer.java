package com.sbj.threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		new Producer(queue).start();
		new Consumer(queue).start();
	}
}

class Producer extends Thread{
	
	private BlockingQueue<Integer> queue;
	private Integer item=0;
	
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		while(true) {
			System.out.println("Item Produced :"+item);
			try {
			queue.put(item++);
			
				System.out.println("..................Producer Sleeping");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread{
	private BlockingQueue<Integer> queue;
	Consumer(BlockingQueue<Integer> queue){
		this.queue = queue;
	}
	@Override
	public void run() {
		while(true) {
			
			try {
				System.out.println("In Consumer");
				System.out.println("Item Consumed :"+queue.take());
				System.out.println("..................Consumer Sleeping");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
