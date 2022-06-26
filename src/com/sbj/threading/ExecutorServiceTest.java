package com.sbj.threading;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {

	public static void main(String[] args) {

		List<MyTask> list = new ArrayList<>();
		for(int i = 0; i < 9 ; i++) {
			list.add(new MyTask());
		}
		ExecutorService executor = Executors.newFixedThreadPool(3);
		try {
			List<Future<String>> futureObject = executor.invokeAll(list);
			System.out.println("looping through Output:"+ LocalDateTime.now());
			for(Future<String> f : futureObject) {
				System.out.println(f.get());
			}
			System.out.println("looping through Finished:"+ LocalDateTime.now());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class MyTask implements Callable<String>{

	@Override
	public String call() throws Exception {
		String valueToBeReturned  = LocalDateTime.now()+ " : "+ Thread.currentThread().getName();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valueToBeReturned;
	}
	
}
