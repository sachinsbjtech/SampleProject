package com.sbj.practice;

public class NumberOfIslands {

	public static void main(String[] args) {
		char grid[][] = {
		        {'1','1','1','1','0'},
		        {'1','1','0','1','0'},
		        {'1','1','0','0','0'},
		        {'0','0','0','0','0'}
		};
		System.out.println(new NumberOfIslands().numIslands(grid));
	}
	
	public int numIslands(char[][] grid) {
		int count = 0;
		for(int i = 0; i < grid.length ; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == '1') {
					traverse(grid, i, j);
					count++;
				}
			}
		}
		return count;
    }

	private void traverse(char[][] grid, int i, int j) {
		// when in recursion index are out of range or cell is 0 then just return  to move to next combination
		if(i<0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j]=='0'  ) {
			return;
		}
		// skip recalculation.
		grid[i][j]= '0';
		
		//traverse all 4 sides
		traverse(grid, i+1, j);
		traverse(grid, i-1, j);
		traverse(grid, i, j+1);
		traverse(grid, i, j-1);
	}

}
