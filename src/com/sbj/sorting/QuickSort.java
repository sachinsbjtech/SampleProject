package com.sbj.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {9,14, 2, 1, 10};
		quickSort(arr, 0, arr.length -1);
		Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
	}
	
	static void quickSort(int[] arr, int low, int high) {
		if(low < high) {
			int pivot = partition(arr, low, high);
			
			quickSort(arr, low, pivot -1);
			quickSort(arr, pivot +1 , high);
		}
	}

	private static int partition(int[] arr, int low, int high) {

		// pick a pivot element
		int pivot = arr[high];
		
		// smallest element index
		int smallest = low-1;
		
		//find element greater than pivot
		for(int i =low ; i < high ; i++) {
			if(arr[i] < pivot) {
				smallest++;
				swap(i, smallest, arr);
			}
		}
		swap(smallest+1, high, arr);
		return smallest+1;
	}

	private static void swap(int i, int j, int[] arr) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
