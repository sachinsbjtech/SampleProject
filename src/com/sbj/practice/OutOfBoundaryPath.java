package com.sbj.practice;

public class OutOfBoundaryPath {
	/**
	 * There is an m x n grid with a ball. 
	 * The ball is initially at the position [startRow, startColumn]. 
	 * You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). 
	 * You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. 
Since the answer can be very large, return it modulo 10^9 + 7.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int totalCount = 0;
        findNextPath(m, n, maxMove, startRow, startColumn);
        	
        return totalCount;
    }

	private int findNextPath(int m, int n, int maxMove, int startRow, int startColumn) {
		if(startRow < 0 || startRow >= m || startColumn <0 || startColumn >=n) {
			return 1;
		}
		 
		int totalCount = findNextPath(m+1, n, maxMove -1, startRow, startColumn) +1;
		totalCount = findNextPath(m-1, n, maxMove -1, startRow, startColumn) +1;
		totalCount = findNextPath(m, n+1, maxMove -1, startRow, startColumn) +1;
		totalCount = findNextPath(m, n-1, maxMove -1, startRow, startColumn) +1;
		
		return totalCount;
	}

}
