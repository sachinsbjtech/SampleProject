package com.sbj.practice;

public class CountSubIsland {
	/**
	 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid11[][] = {{1,1,1,0,0},
		                 {0,1,1,1,1},
		                 {0,0,0,0,0},
		                 {1,0,0,0,0},
		                 {1,1,0,1,1}};
		
		int grid22[][] = {{1,1,1,0,0},
						{0,0,1,1,1},
						{0,1,0,0,0},
						{1,0,1,1,0},
						{0,1,0,1,0}};
		
		int grid1[][] = {{1,0,1,0,1},
						 {1,1,1,1,1},
						 {0,0,0,0,0},
						 {1,1,1,1,1},
						 {1,0,1,0,1}};
		int grid2[][] =	{{0,0,0,0,0},
						 {1,1,1,1,1},
						 {0,1,0,1,0},
						 {0,1,0,1,0},
						 {1,0,0,0,1}};
		
		//[[1,1,1,1,0,0],[1,1,0,1,0,0],[1,0,0,1,1,1],[1,1,1,0,0,1],[1,1,1,1,1,0],[1,0,1,0,1,0],[0,1,1,1,0,1],[1,0,0,0,1,1],[1,0,0,0,1,0],[1,1,1,1,1,0]]
		//[[1,1,1,1,0,1],[0,0,1,0,1,0],[1,1,1,1,1,1],[0,1,1,1,1,1],[1,1,1,0,1,0],[0,1,1,1,1,1],[1,1,0,1,1,1],[1,0,0,1,0,1],[1,1,1,1,1,1],[1,0,0,1,0,0]]
		System.out.println(new CountSubIsland().countSubIslands(grid1, grid2));
	}
	
	public int countSubIslands(int[][] grid1, int[][] grid2) {
		int subIslandCount = 0;
        for(int i =0 ; i < grid2.length ; i++) {
        	for(int j = 0; j < grid2[i].length ; j++) {
        		if(grid2[i][j]==1 && grid1[i][j]==1) {
        			if(findSubIsland(grid1,grid2,i,j)) {
        			System.out.print("i="+i+", j="+j);
        				subIslandCount++;
        			}
        		}
        	}
        	System.out.println();
        }
        return subIslandCount;
    }

	private boolean findSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
		if(i<0 || j<0 || i >=grid2.length || j>=grid2[i].length || grid2[i][j] == 0) {
			return true;
		}
		if(grid2[i][j]==1 && grid1[i][j]==0) {
			return false;
		}
		grid2[i][j]=0;
		boolean left = findSubIsland(grid1, grid2, i+1, j);
		boolean right = findSubIsland(grid1, grid2, i-1, j);
		boolean bottom = findSubIsland(grid1, grid2, i, j+1);
		boolean up = findSubIsland(grid1, grid2, i, j-1);
		
		return left && right && bottom && up;
		
	}
}
