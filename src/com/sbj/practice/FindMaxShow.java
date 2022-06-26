package com.sbj.practice;

import java.util.Scanner;

/**
 * First line input - Total Number of months in a year in part and number of consecutive months can be stayed and watch shows e.g. 3 2 
 * Second line input - total number of shows can be viewed in a month 1 4 2
 *  Find max number of shows can be viewed , allowed months can go to next year. like check can go circular   
 * 
 * @author sacjadha
 *
 */
public class FindMaxShow {

	private static int findMaxShow(int N, int K, int A[]) {
		int maxShow = 0;
		for(int i = 0; i < A.length ; i++) {
			int totalSum = 0;
			for(int j = 0, counter = i; j < K ; j++, counter++) {
				totalSum = totalSum + A[counter];
				if(counter == (A.length -1)) {
					// counter is incremented at loop so -1 will keep effect to 0 
					counter = -1;
				}
			}
			if(totalSum > maxShow ) {
				maxShow = totalSum;
			}
		}
		return maxShow;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int A[] = new int[N];
		int i = 0;
		while(i < N && sc.hasNext() ) {
			A[i] = sc.nextInt();
			i++;
		}

		System.out.println(findMaxShow(N, K, A));
	}
}
