package com.sbj.practice;

public class RegionCutBySlashes {

	public static void main(String[] args) {
		
	}
	public int regionsBySlashes(String[] grid) {
		if(grid.length == 0) {
			return 0;
		}
		int count = 0;
		// To represent / or \ we need size * 3 representation
		int g[][] = new int[grid.length * 3][grid[0].length()*3];
		for(int i= 0 ; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length() ; j++) {
				if(grid[i].charAt(j)=='/'){
					g[i*3][j*3 +2] = 1;
					g[i*3 + 1][j*3 +1] =1;
					g[i*3 + 2][j*3]=1;
				}else if(grid[i].charAt(j)=='\\') {
					g[i*3][j*3]=1;
					g[i*3 +1][j*3 +1]=1;
					g[i*3 + 2][j*3 +2]=1;
				}
			}
		}
		
		for(int i =0; i < g.length ; i++) {
			for(int j = 0; i < g[i].length ; j++) {
				dfs(g, i,j);
				count++;
			}
		}
		
		
        return count;
        
    }
	private void dfs(int[][] g, int i, int j) {
		if(i < 0 || j <0 || i>=g.length || j >=g[i].length || g[i][j] ==1) {
			return;
		}
		g[i][j] = 1;
		int d[]= {0,-1,0,1,0};
		for(int k =0; k <4 ;k++) {
			dfs(g,i +d[k],j+d[k+1]);
		}
	}
}
