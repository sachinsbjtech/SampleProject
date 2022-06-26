package com.sbj.practice;

public class RottingOranges {

	/**
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
	 */
	public static void main(String[] args) {
		//int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};
		//int grid[][] = {{0,2}};
		//int grid[][] = {{2,1,1},{0,1,1},{1,0,1}};
		
		int grid[][] =  {{2,0,1,1,1,1,1,1,1,1},
						 {1,0,1,0,0,0,0,0,0,1},
						 {1,0,1,0,1,1,1,1,0,1},
						 {1,0,1,0,1,0,0,1,0,1},
						 {1,0,1,0,1,0,0,1,0,1},
						 {1,0,1,0,1,1,0,1,0,1},
						 {1,0,1,0,0,0,0,1,0,1},
						 {1,0,1,1,1,1,1,1,0,1},
						 {1,0,0,0,0,0,0,0,0,1},
						 {1,1,1,1,1,1,1,1,1,1}};
		System.out.println(new RottingOranges().orangesRotting(grid));
	}
	
	private int rot(int[][] g, int i, int j, int d) {
		  if (i < 0 || j < 0 || i >= g.length || j >= g[i].length || g[i][j] != 1) return 0;
		  g[i][j] = d + 3;
		  return 1;
		}
		public int orangesRotting1(int[][] g) {
		  int fresh = 0, d = 0;
		  for (int i = 0; i < g.length; ++i)
		    for (int j = 0; j < g[i].length; ++j)
		      if (g[i][j] == 1) ++fresh;
		  for (int old_fresh = fresh; fresh > 0; ++d, old_fresh = fresh) {
		    for (int i = 0; i < g.length; ++i)
		      for (int j = 0; j < g[i].length; ++j)
		        if (g[i][j] == d + 2)
		          fresh -= rot(g, i + 1, j, d) + rot(g, i - 1, j, d) + rot(g, i, j + 1, d) + rot(g, i, j - 1, d);
		    if (fresh == old_fresh) return -1;
		    for(int ii=0 ; ii < g.length ; ii++) {
				for(int jj =0; jj < g[ii].length ; jj++) {
					System.out.print(g[ii][jj]+" ");
					/*
					 * if(grid[i][j]==1) { return -1; }
					 */
				}
				System.out.println();
			}
		    System.out.println("----------------------------");
		  }
		  return d;
		}
	
	public int orangesRotting(int[][] grid) {
		// count total fresh oranges
		int freshOranges = 0;
		for(int i =0; i < grid.length ; i++) {
			for(int j=0; j < grid[i].length; j++) {
				if(grid[i][j]==1) {
					freshOranges++;
				}
			}
		}
		// Update fresh orange cell to 2 
		int d =0;
		for(int oldFresh = freshOranges ; freshOranges > 0;  d++,oldFresh = freshOranges ) {
			for(int i =0 ; i< grid.length;i++) {
				for(int j=0; j < grid[i].length; j++) {
					if(grid[i][j]==d+2) {
						freshOranges-= rot(i+1,j, d,grid) + rot(i-1,j, d,grid) +rot(i,j+1, d,grid) + rot(i,j-1, d,grid);
					}
				}
			}
			
			if(oldFresh == freshOranges) {
				// did not rotted fresh orages 
				return -1;
			}
		}
		return d;
	}
	
	private int rot(int i, int j, int k, int[][] grid) {
		if( i < 0 || j < 0 || i >=grid.length || j >=grid[i].length || grid[i][j]!=1) {
			return 0;
		}
		grid[i][j]=k+3;
		return 1;
	}

	int minutesNeeded = 0;
	public int orangesRottingOLD(int[][] grid) {
		//int minutes = 0;
		for(int i = 0; i <grid.length ; i++) {
			for(int j =0; j < grid[i].length; j++) {
				if(grid[i][j]==2) {
					/*
					 * if(rootingEveryAfterOneMin(i, j, grid)) { minutes++; }
					 */
					rootingEveryAfterOneMinNEW(i, j, grid);
				}
			}
		}
		
		for(int i=0 ; i < grid.length ; i++) {
			for(int j =0; j < grid[i].length ; j++) {
				System.out.print(grid[i][j]+" ");
				/*
				 * if(grid[i][j]==1) { return -1; }
				 */
			}
			System.out.println();
		}
		return minutesNeeded;
    }

	private boolean rootingEveryAfterOneMin(int i, int j, int[][] grid) {
		boolean isRootan = false;
		if( i+1 <grid.length && grid[i+1][j]==1) {
			isRootan=true;
			grid[i+1][j]=2;
		}
		if(i-1 >=0 && grid[i-1][j]==1) {
			isRootan=true;
			grid[i-1][j]=2;
		}
		if(j+1 < grid[i].length && grid[i][j+1]==1) {
			isRootan=true;
			grid[i][j+1 ]=2;
		}
		if(j-1 >= 0 && grid[i][j-1]==1) {
			isRootan=true;
			grid[i][j-1]=2;
		}
		return isRootan;
	}

	private boolean rootingEveryAfterOneMinNEW(int i, int j, int grid[][]) {
		if( i < 0 || j < 0 || i >= grid.length || j >=grid[i].length || grid[i][j]==0) {
			return false;
		}
		//System.out.println("i="+i+", j="+j+", value="+grid[i][j]);
		// if in recursion
		if(grid[i][j]==1) {
			grid[i][j]=2;
			return true;
		}
		boolean down = rootingEveryAfterOneMinNEW(i+1,j, grid);
		boolean up = rootingEveryAfterOneMinNEW(i-1,j, grid);
		boolean right = rootingEveryAfterOneMinNEW(i,j+1, grid);
		boolean left = rootingEveryAfterOneMinNEW(i,j-1, grid);
		
		if(down || up || right || left) {
			minutesNeeded++;
			return true;
		}
		return false;
	}
}
