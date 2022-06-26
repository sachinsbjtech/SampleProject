package com.sbj.practice;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

	/**
	 * 
	 * There are n cities. Some of them are connected, while some are not. 
	 * If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 
if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int isConnected[][] = {{1,1,0},{1,1,0},{0,0,1}};
		//int isConnected[][] = {{1,0,0},{0,1,0},{0,0,1}};
		System.out.println(new NumberOfProvinces().findCircleNum(isConnected));
	}

	public int findCircleNumOLD(int[][] isConnected) {
        List<List<Integer>> list = new ArrayList<>();
        
        //make list of paths
        for(int i =0;i < isConnected.length ; i++) {
        	for(int j =0; j < isConnected[i].length ; j++) {
        		if(isConnected[i][j]==1 && i!=j) {
        			if(list.get(i)==null) {
        				list.add(new ArrayList<Integer>());
        			}
        			list.get(i).add(j);
        		}
        	}
        }
        List<List<Integer>> numberOfProvinces = new ArrayList<List<Integer>>();
        for(int i =0 ; i< list.size() ; i++) {
        	List<Integer> provinces = new ArrayList<Integer>();
        	provinces.add(i);
        	for(Integer item : list.get(i)) {
        		provinces.add(item);
        	}
        }
        
        return 0;
    }
	
	public int findCircleNum(int[][] isConnected) {
		int count =0;
		boolean visited[] =new boolean[isConnected.length];
		
		for(int i =0;i < isConnected.length;i++) {
			if(!visited[i]) {
				dfs(i, isConnected,visited);
				count++;
			}
		}
		return count;
	}

	private void dfs(int i, int[][] isConnected, boolean[] visited) {
		for(int j =0 ;  j< isConnected[i].length; j++) {
			if(isConnected[i][j]==1 && !visited[j]) {
				visited[j]= true;
				// visit next found index
				dfs(j, isConnected, visited);
			}
		}
	}
}
