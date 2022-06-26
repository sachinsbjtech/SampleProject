package com.sbj.nonlinearDS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class EarlierMomentEveryoneBecomeFriend {
	/**
	 *
	 * Given a group of N people, each having a unique ID value from 0 to (N – 1) and an 
	 * array arr[] of M elements of the form {U, V, time} representing that the person U will become acquainted 
	 * with person V at the given time. Let’s say that person U is acquainted with person V if U is friends with V, 
	 * or U is a friend of someone acquainted with V. The task is to find the earliest time at which every person 
	 * became acquainted with each other.
	 */
	public static void main(String[] args) {
		//int n = 4; int arr[][] = {{0, 1, 2}, {1, 2, 3}, {2, 3, 4}};
		int n = 6; 
		int arr[][] = {{0, 1, 4}, {3, 4, 5}, {2, 3, 14}, {1, 5, 24}, {2, 4, 12}, {0, 3, 42}, {1, 2, 41}, {4, 5, 11}};
		System.out.println(new EarlierMomentEveryoneBecomeFriend().findTimeRequired(n, arr));
	}
	
	public int findTimeRequired(int n, int[][] input) {
		long startTime = System.currentTimeMillis();
		Map<Integer, List<List<Integer>>> inputMap = new TreeMap<>();
		List<List<Integer>> resultList = new ArrayList<List<Integer>>(); 

		for(int i=0;i<=n;i++) {
			List<Integer> itemList = new ArrayList<Integer>();
			itemList.add(i);
			resultList.add(itemList);
			
		}
		int timeRequired = 0;
		// store input values in TreeMap , Time is Key 
		for(int i =0; i< input.length ; i++) {
			List<Integer> itemList = new ArrayList<Integer>();
			itemList.add(input[i][0]);
			itemList.add(input[i][1]);
			
			if(inputMap.get(input[i][2])!=null) {
				inputMap.get(input[i][2]).add(itemList);
			}else {
				List<List<Integer>> mapValue = new ArrayList<List<Integer>>();
				mapValue.add(itemList);
				inputMap.put(input[i][2],mapValue);
			}
		}
		
		
		for(Entry<Integer, List<List<Integer>>> entry : inputMap.entrySet()) {
			for(List<Integer> item : entry.getValue()) {
				// First number index
				int firstIndex = findIndexOfSubSetItem(item.get(0), resultList);
				// second number index
				int secondIndex = findIndexOfSubSetItem(item.get(1), resultList);
				// when firstIndex != secondIndex then Union of firstIndex and secondIndex set
				if(firstIndex != secondIndex) {
					unionOfTwoSets(firstIndex, secondIndex, resultList);
					timeRequired = entry.getKey();
				}
			}
		}
			
		System.out.println("Time Taken="+ (System.currentTimeMillis() - startTime));
		
		return timeRequired;
	}
	
	private void unionOfTwoSets(int firstIndex, int secondIndex, List<List<Integer>> resultList) {
		 resultList.get(firstIndex).addAll(resultList.get(secondIndex));
		 resultList.remove(secondIndex);
	}

	private int findIndexOfSubSetItem(int num, List<List<Integer>> list) {
		for(int i = 0; i < list.size(); i++) {
			for(Integer item : list.get(i)) {
				if(item == num ) {
					return i;
				}
			}
		}
		return -1;
	}

}
 