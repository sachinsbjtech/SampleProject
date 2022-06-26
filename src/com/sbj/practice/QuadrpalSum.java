package com.sbj.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrpalSum {

	public static void main(String[] args) {
		
		//int nums[] = {1,0,-1,0,-2,2};
		int nums[] = {-3,-2,-1,0,0,1,2,3};
		System.out.println(fourSum(nums, 0));
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4){
            return new ArrayList<List<Integer>>();
        }
        
        Arrays.sort(nums);
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        for(int a =0; a< nums.length -3 ; a++){
            if(a > 0 && nums[a-1]==nums[a]){
                continue;
            }
            for(int b = a+1; b < nums.length -2; b++){
            	if(b > a+1 && nums[b-1]==nums[b]) {
            		continue;
            	}
                findRemaniningNumbers(nums, target, a, b, finalList);
            }
        }
        return finalList;
    }
    
    private static void findRemaniningNumbers(int nums[], int target, int a, int b, List<List<Integer>> list){
        int c = b+1, d= nums.length -1;
        
        
        while(c<d){
        	int sum = nums[a]+nums[b]+nums[c]+nums[d];
            if(sum == target){
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(nums[a]);
                newList.add(nums[b]);
                newList.add(nums[c]);
                newList.add(nums[d]);
                list.add(newList);

                while(c<d && nums[c]==nums[c+1]){
                    c++;
                }
                while(c<d && nums[d]==nums[d-1]){
                    d--;
                }
                c++;
                d--;
            }else if(sum > target){
                d--;
            }else{
                c++;
            }
        }
    }
}
