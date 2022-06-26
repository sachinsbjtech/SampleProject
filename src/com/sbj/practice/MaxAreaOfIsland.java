package com.sbj.practice;

public class MaxAreaOfIsland {
	/*
	 * 
	 * You are given an m x n binary matrix grid. 
	 * An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
	 * You may assume all four edges of the grid are surrounded by water.

	The area of an island is the number of cells with a value 1 in the island.
	Return the maximum area of an island in grid. If there is no island, return 0.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
		                {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                {0,1,1,0,1,0,0,0,0,0,0,0,0},
		                {0,1,0,0,1,1,0,0,1,0,1,0,0},
		                {0,1,0,0,1,1,0,0,1,1,1,0,0},
		                {0,0,0,0,0,0,0,0,0,0,1,0,0},
		                {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
	}
	
	public int maxAreaOfIsland(int[][] grid) {
		int maxArea =0;
		for(int i =0; i < grid.length ; i++) {
			for(int j = 0; j <grid[i].length ; j++) {
				if(grid[i][j]== 1) {
					int newArea = maxArea(grid, i, j,0);
					maxArea = newArea > maxArea ? newArea : maxArea;
				}
			}
		}
		return maxArea;
    }

	private int maxArea(int[][] grid, int i, int j, int maxArea) {
		if(i<0 || j<0 || i>=grid.length || j >=grid[i].length || grid[i][j]== 0 ) {
			return maxArea;
		}
		
		if(grid[i][j]==1) {
			maxArea+=1;
		}
		grid[i][j]=0;
		
		maxArea = maxArea(grid, i+1,j,maxArea);
		maxArea = maxArea(grid, i-1,j,maxArea);
		maxArea = maxArea(grid, i,j+1,maxArea);
		maxArea = maxArea(grid, i,j-1,maxArea);
		
		return maxArea;
	}

}
