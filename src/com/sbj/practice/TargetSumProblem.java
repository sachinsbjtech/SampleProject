package com.sbj.practice;

public class TargetSumProblem {
	public static void main(String[] args) {
		int a[] = {2,3,5,7,8,18};
		int targetSum = 20;
		System.out.println(checkIfTargetSumPresent(a,targetSum));
	}

	private static boolean checkIfTargetSumPresent(int[] a, int targetSum) {
		//return checkSum(a, targetSum, a.length);
		return checkSumWithDP(a, targetSum, a.length);
	}

	private static boolean checkSum(int[] a, int targetSum, int length) {
		if(length == 0) {
			return false;
		}
		if(a[length -1] > targetSum) {
			return checkSum(a, targetSum, length-1);
		}else {
			if((a[length - 1 ] - targetSum) ==0) {
				return true;
			}else {
				//include or dont include
				return checkSum(a, targetSum - a[length -1], length -1);
			}
		}
	}
	
	private static boolean checkSumWithDP(int[] a, int targetSum, int length) {
		boolean temp[][] = new boolean[length+1][targetSum+1];
		
		for(int i = 0; i< length ; i++) {
			temp[i][0] = true;
		}
		for(int j =1 ; j < targetSum ; j++) {
			temp[0][j]= false;
		}
		
		for(int i = 1 ; i <= length ; i++) {
			for(int j = 1; j <= targetSum ; j++) {
				//System.out.println("i="+i+", j="+j+", a[i]");
				if(a[i-1] > j) {
					temp[i][j] = temp[i-1][j];
				}else {
					temp[i][j]=temp[i-1][j] || temp[i-1][j-a[i-1]];
				}
				/*
				 * if(a[i - 1 ] <= j) { temp[i][j] = temp[i][j - a[ i -1]] || temp[i-1][j];
				 * }else { temp[i][j] = temp[i-1][j]; }
				 */
			}
		}
		return temp[length][targetSum];
	}
}
