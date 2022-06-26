package com.sbj.practice;

import java.util.Arrays;

public class TargetSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputArray[] = {1, 4, 20, 3, 10, 5};
		int subArray[] = getSubArray(inputArray, 33);
		if(subArray!=null) {
			for(int i  = 0; i < subArray.length ; i++) {
				System.out.println(subArray[i]);
			}
		}
	}

	private static int[] getSubArray(int[] inputArray, int taregtSum) {
		for(int i = 0 ; i < inputArray.length ; i++) {
			int tempSum = 0;
			for(int j = i ; j < inputArray.length; j++) {
				tempSum += inputArray[j];
				if(tempSum == taregtSum) {
					return new int[] {i,j};
				}else if(tempSum > taregtSum){
					break;
				}
			}
		}
		return null;
	}

}
