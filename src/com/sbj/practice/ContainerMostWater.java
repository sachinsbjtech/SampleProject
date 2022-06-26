package com.sbj.practice;

public class ContainerMostWater {

	public static void main(String[] args) {
		//int[] height = {1,8,6,2,5,4,8,3,7};
		int[] height = {1,1};
		System.out.println("MaxArea :"+maxArea1(height));
				
	}
	
	static public int maxArea(int[] height) {
		
		if(height.length == 2) {
			return Math.min(height[0], height[1]);
		}
		int maxArea = 0;
		for(int i =0 ; i < height.length; i++) {
			for(int j = i+1; j < height.length; j++) {
				
				int newArea = Math.min(height[i] , height[j]) * (j -i);
				if(newArea > maxArea) {
					maxArea = newArea;
				}
			}
		}
        return maxArea;
    }
	
	static public int maxArea1(int[] height) {
		
		int maxArea = 0;
		int i = 0, j = height.length-1;
		/*
		 * for(int i =0 ; i < height.length; i++) { for(int j = i+1; j < height.length;
		 * j++) {
		 * 
		 * int newArea = Math.min(height[i] , height[j]) * (j -i); if(newArea > maxArea)
		 * { maxArea = newArea; } } }
		 */
		
		while(i < j) {
			maxArea = Math.max(maxArea, Math.min(height[i] , height[j]) * (j -i)); 
			if(height[i] < height[j]) {
				i++;
			}else {
				j--;
			}
		}
        return maxArea;
    }

}
