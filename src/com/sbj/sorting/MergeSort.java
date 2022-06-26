package com.sbj.sorting;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {12, 11, 13, 5, 6};
		
		int temp[] = mergeSort(arr,0,arr.length-1);
		System.out.println();
	}

	private static int[] mergeSort(int[] arr, int f, int l) {
		if(f == l) {
			return arr;
		}
		int middle = f + (l-f)/2;
		
		int arr1[] = mergeSort(arr, f, middle);
		int arr2[] = mergeSort(arr, middle+1,l);
		
		int temp[] =  new int[arr1.length + arr2.length];
		// merge part
		int i = 0, j = 0,k=0;
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i] < arr2[j]) {
				temp[k] = arr1[i];
				i++;
			}else  {
				temp[k] = arr1[j];
				j++;
			}
			k++;
		}
		
		// merge remaining items to temp
		if(i < arr1.length -1) {
			while(i < (arr1.length -1)) {
				temp[k] = arr1[i];
				i++;
				k++;
			}
		}
		
		if(j < arr2.length -1) {
			while(j < (arr2.length-1)) {
				temp[k] = arr2[j];
				j++;
				k++;
			}
		}

		
		
		return temp;
	}

}
