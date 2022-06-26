package com.sbj.practice;

import java.util.HashMap;
import java.util.Map;


public class DateConversion {
	public static void main(String[] args) throws InterruptedException {
		long t1 = System.currentTimeMillis();
		Thread.sleep(1000);
		long t2 = System.currentTimeMillis();
		System.out.println(t2 -t1);
		System.out.println((long)Double.MAX_VALUE);
		Map<String, Integer> testMap = new HashMap<String, Integer>();
		testMap.put("Test1", 2);
		testMap.put("Test2", 3);
		System.out.println(testMap);
		
	}
}
