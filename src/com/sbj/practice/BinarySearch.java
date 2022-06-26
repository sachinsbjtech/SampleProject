package com.sbj.practice;

import java.util.Arrays;

public class BinarySearch {
	
	
	public static void main(String[] args) {
		int a[] = {1 , 5, 2, 4, 6, 7, 3};
		Arrays.sort(a);
		
		(new BinarySearch()).bSearch(a, 2, 0, a.length-1);
	}

	private void bSearch(int[] array, int value, int low, int high) {
		int mid = low + (high - low) /2;
		if((array.length -1) >= mid) {
			if(array[mid] == value) {
				System.out.println("Value found");
			}
			else if(array[mid] > value) {
				bSearch(array, value, low, mid);
			}else {
				bSearch(array, value, mid, high);
			}
		}
		
		
	}
}
