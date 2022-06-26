package com.sbj.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {64,25,12,22,11};
		int minIndex = 0;
		for(int i = 0; i < arr.length -1 ; i++) {
			for(int j = i+1; j < arr.length ; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		System.out.println();
	}

}
