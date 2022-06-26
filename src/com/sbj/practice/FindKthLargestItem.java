package com.sbj.practice;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargestItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7, 10, 4, 3, 20, 15} ;
		System.out.println(new FindKthLargestItem().kthLargest(3, arr));
	}
	
	public int kthLargest(int k, int arr[]) {
		/*
		 * Queue<Integer> queue = new PriorityQueue<Integer>(); for(int i= 0; i <
		 * arr.length; i++) { queue.add(arr[i]); }
		 */
		
		// Try with Quick sort
		quickSort( arr, 0, arr.length-1);
		
		return arr[k];
	}

	private void quickSort(int[] arr, int low, int high) {
		if(low >= high) {
			return;
		}
		int pivot = high;
		
		int l =0;
		int r =high-1;
		int temp = 0;
		while(l<r) {
			if(arr[l]<arr[pivot]) {
				l++;
			}else if(arr[r]>arr[pivot]) {
				r--;
			}else {
				temp = arr[l];
				arr[l]=arr[r];
				arr[r]=temp;
			}
		}
		// move initial pivot to its actual place
		temp = arr[pivot];
		arr[pivot] = arr[l];
		arr[l]=temp;
		// run quick sorting left and right of pivot 
		quickSort(arr,low,l-1);
		quickSort(arr,l+1,high);
		
	}

}
