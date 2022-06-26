package com.sbj.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 11, 13, 5, 6};
		// 6,2,5,4
		// 2,6,5,4
		
		for(int i = 1; i < arr.length ; i++) {
			for(int j =0 ; j < i ; j++) {
				if(arr[j] > arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println();
	}

}
