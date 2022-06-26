package com.sbj.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripletSum {

	public static void main(String[] args) {
		int nums[] = {-1,0,1,2,-1,-4};
		//int nums[] = {0};
		System.out.println(threeSum(nums));

	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		
		if(nums.length < 3 ) {
			return new ArrayList<List<Integer>>();
		}
		Arrays.sort(nums);

		//Set<Integer> sumSet = new HashSet<Integer>();
		//findArrayWithSum(nums, 0, nums.length, sumSet);
		List<List<Integer>> finalList= new ArrayList<List<Integer>>();
		for(int i = 0; i < nums.length; i++) {
			if( i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			findRemaniningNumbers(nums, i, finalList);
		}

		return finalList;
	}

	private static void findRemaniningNumbers(int[] nums, int startFrom, List<List<Integer>> finalList) {
		
		int left = startFrom+1, right = nums.length -1;
		
		/*
		 * for(int i = startFrom ; i < nums.length ; i++) {
		 * 
		 * if(tempMap.containsKey(nums[i]) ) { Integer j = tempMap.get(nums[i]); //
		 * found all 3 nums , compare if they are equal // here k will be i which is 3rd
		 * num if(nums[startFrom -1]!= nums[j] && nums[j]!=nums[i] && nums[startFrom
		 * -1]!= nums[i]) { List<Integer> newArray = new ArrayList<Integer>();
		 * newArray.add(nums[startFrom -1]); newArray.add(nums[j]);
		 * newArray.add(nums[i]); return newArray; } break; }else { tempMap.put(target -
		 * nums[i], i); } }
		 * 
		 * return null;
		 */
		
		while(left < right) {
			int sum = nums[startFrom]+nums[left]+nums[right];
			
			if(sum == 0) {
				List<Integer> newArray = new ArrayList<Integer>();
				newArray.add(nums[startFrom]); 
				newArray.add(nums[left]);
				newArray.add(nums[right]);
				finalList.add(newArray);
				
				//skip duplicates
				while(left < right && nums[left]==nums[left+1]) {
					left++;
				}
				
				//skip duplicates
				while(left < right && nums[right]==nums[right-1]) {
					right--;
				}
				
				left++;
				right--;
			}else if(sum >0) {
				right--;
			}else {
				left++;
			}
		}
	}

	
	
	/*
	 * private static Set<Integer> findArrayWithSum(int[] nums, int sum, int length,
	 * Set<Integer> sumSet) {
	 * 
	 * if(sumSet.size() == 3 || length > 0) { return sumSet; }
	 * 
	 * if(sumSet.size() < 3 )
	 * 
	 * }
	 */

}
