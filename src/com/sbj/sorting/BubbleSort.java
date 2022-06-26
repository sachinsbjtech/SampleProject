package com.sbj.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 10, 14};
		sort(arr);
	}

	static void sort(int arr[]) {
		for(int j = arr.length -1 ; j >= 0 ; j--) {
			boolean swapFlag = false;
			for(int i = 0; i < j ; i++) {
				System.out.println("Compare "+arr[i]+"  "+arr[i+1]);
				if(arr[i] > arr[i+1]) {	
					arr[i] = arr[i] + arr[i+1];
					arr[i+1] = arr[i] - arr[i+1];
					arr[i] = arr[i] - arr[i+1];
					swapFlag = true;
				}
			}
			if(!swapFlag) {
				break;
			}
			Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
			System.out.println();
		}
		
	}
}
