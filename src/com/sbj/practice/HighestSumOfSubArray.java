package com.sbj.practice;

import java.util.Arrays;

public class HighestSumOfSubArray {

	// SubArray with Highest Sum 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-2,-1,-3};
		
		// There should not be any sorting 
		
		findHighestSum(arr, arr.length);
		findHighestSum1(arr, arr.length);
		
	}

	private static void findHighestSum(int[] arr, int length) {
		int largestSum = 0, currentSum = 0 ;
		
		for(int i = 0; i < length ; i++) {
			currentSum = currentSum + arr[i];
			if(currentSum > largestSum) {
				largestSum = currentSum;
			}else {
				currentSum = 0;
			}
		}
		System.out.println(largestSum);
	}
	
	private static void findHighestSum1(int[] arr, int length) {
		int maxSum = arr[0],leftPosition = 0;
		
		for(int i = 0; i < length ; i++) {
			maxSum = Math.max(maxSum, leftPosition+arr[i]);
			leftPosition = Math.max(0, leftPosition+arr[i]);
		}
		System.out.println(maxSum);
	}

}
