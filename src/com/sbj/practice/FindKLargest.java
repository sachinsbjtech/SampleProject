package com.sbj.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKLargest {

	public static void main(String[] args) {
		int inputArray[] = {1, 23, 12, 9, 30, 2, 50};
		new FindKLargest().findKLargest(inputArray);
	}
	
	public int[] findKLargest(int inputArray[]) {
		int kLargest[] = new int [3];
		
		Queue<Integer> q  = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for(int i =0; i< inputArray.length ; i++) {
			q.add(inputArray[i]);
		}
		
		
		kLargest[0]= q.poll();
		System.out.println(kLargest[0]);
		kLargest[1]= q.poll();
		System.out.println(kLargest[1]);
		kLargest[2]= q.poll();
		System.out.println(kLargest[2]);
		
		
		return kLargest;
	}

}
