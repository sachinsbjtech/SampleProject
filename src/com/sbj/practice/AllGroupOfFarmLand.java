package com.sbj.practice;

	import java.util.ArrayList;
	import java.util.List;

public class AllGroupOfFarmLand {

	/**
You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.

To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.

land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].

Return a 2D array containing the 4-length arrays described above for each group of farmland in land. If there are no groups of farmland, return an empty array. You may return the answer in any order.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int land[][] = {{1,0,0},{0,1,1},{0,1,1}};
		//int land[][] = {{1,1},{1,1}};
		//int land[][] = {{0,1},{1,0}};
		int land[][] = {{1,1,0,0,0,1},{1,1,0,0,0,0}};
		
		int coordinates[][] = new AllGroupOfFarmLand().findFarmland(land);
		for(int i = 0; i < coordinates.length ; i++) {
			System.out.print(coordinates[i][0]+" "+coordinates[i][1]+" "+coordinates[i][2]+" "+coordinates[i][3]);
			System.out.println();
		}
	}
	
	int bottomRightX = -1;
	int bottomRightY = -1;
	
	public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        for(int  i=0; i< land.length;i++) {
        	for(int j =0; j < land[i].length; j++) {
        		if(land[i][j]==1) {
        			findCoordinates(land,i,j);
        			list.add(new int[]{i,j,bottomRightX,bottomRightY});
        			bottomRightX = -1;
        			bottomRightY = -1;
        		}
        	}
        }
        
        
        return list.toArray(new int[list.size()][]);
    }

	private void findCoordinates(int[][] land, int i, int j) {
		if(i < 0 || j <0 || i>=land.length || j >= land[i].length || land[i][j]==0) {
			return;
		}
		
		if(land[i][j]==1) {
			bottomRightX = Integer.max(i, bottomRightX);
			bottomRightY = Integer.max(j, bottomRightY);
		}
		land[i][j]=0;
		findCoordinates(land, i+1, j);
		findCoordinates(land, i-1, j);
		findCoordinates(land, i, j+1);
		findCoordinates(land, i, j-1);
		
	}

}
