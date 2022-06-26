package com.sbj.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TripletSumClosest {

	public static void main(String[] args) {
		int nums[] = {-1,2,1,-4}; //1
		//int nums[] = {1,1,1,0}; // 100, -100
		//int nums[] = {-3,-2,-5,3,-4}; // -2
		//int nums[] = {1,2,4,8,16,32,64,128}; // 82
		System.out.println(threeSumClosest(nums, 1));
		
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		
		if(nums.length < 3) {
			return 0;
		}
    
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		/*
		 * for(int i = 0; i < nums.length -2 ; i++) { for(int j = i+1; j < nums.length-1
		 * ; j++) { int newSum = nums[i] + nums[j]+ nums[j+1]; map.put(Math.abs(target -
		 * newSum), newSum); } } return
		 * (Integer)((TreeMap)map).pollFirstEntry().getValue();
		 */
		Arrays.sort(nums);
		for(int i = 0; i < nums.length  ; i++) {
			findclosestsum(nums, target, i, map);
		}
		
		return (Integer)((TreeMap)map).pollFirstEntry().getValue();
    }

	private static void findclosestsum(int[] nums, int target, int startFrom, Map<Integer, Integer> map) {
		
		int left = startFrom+1, right = nums.length -1;
		
		
		while(left < right) {
			int sum = nums[startFrom]+nums[left]+nums[right];
			
			map.put(Math.abs(target - sum), sum );
			if(sum == target) {
				left++;
				right--;
			}else if(sum > target) {
				right--;
			}else {
				left++;
			}
		}
	}

}
