package com.sbj.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElements {

	public static void main(String[] args) {
		Integer A[] = {1, 1, 2};
		System.out.println(majorityElement(Arrays.asList(A)));
	}
	
	
	
	 public static int majorityElement(final List<Integer> A) {
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 int inputSize = A.size();
		 A.stream().forEach(item -> {
			 if(map.containsKey(item)) {
				 int repetation = map.get(item)+1;
				 map.put(item, repetation);
				/*
				 * if( repetation >= (inputSize /2) ) { majorityElement = item; }
				 */
			 }else {
				 map.put(item, 1);
				// majorityElement = item;
			 }
		 });
		 
		 int  majorityElement = -1;
		
		 for(Entry<Integer, Integer> entry : map.entrySet()) {
			 if(entry.getValue() >= (inputSize/2)) {
				 majorityElement = entry.getKey();
				 break;
			 }
		 }
		 
		return majorityElement;
	 }

}
