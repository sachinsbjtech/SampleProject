package com.sbj.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {1,4,3,7,10,2};
		findLongestIncresingSequence(arr);

	}
	
	static Integer[] findLongestIncresingSequence(int arr[]) {
		List<Integer> longestSequenceList = new ArrayList<Integer>();
		List<Integer> currentList = new ArrayList<Integer>();
		currentList.add(arr[0]);
		for(int i = 1; i < arr.length ; i++) {
			if(arr[i] > arr[i-1]) {
				currentList.add(arr[i]);
			}else {
				//copy all items from current to previous
				if(longestSequenceList.size() < currentList.size()) {
					longestSequenceList.clear();
					longestSequenceList.addAll(currentList);
				}
				currentList.clear();
				currentList.add(arr[i]);
			}
		}
		System.out.println(longestSequenceList);
		return (Integer[])longestSequenceList.toArray();
	}

}
