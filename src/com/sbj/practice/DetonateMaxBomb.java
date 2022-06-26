package com.sbj.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DetonateMaxBomb {

	/**
	 *You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt. This area is in the shape of a circle with the center as the location of the bomb.

The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb, whereas ri denotes the radius of its range.

You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie in its range. These bombs will further detonate the bombs that lie in their ranges.

Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb. 
	 * 
	 */
	public static void main(String[] args) {
		int bombs[][] = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
		//int bombs[][] = {{2,71,5},{16,58,8},{19,28,9},{38,53,3},{80,95,10},{29,74,9},{17,50,10},{94,1,3},{47,64,5},{40,29,7},{65,78,5},{84,95,3},{45,29,1},{56,99,9},{73,3,4},{16,79,4},{79,43,4},{20,27,1},{49,68,6}};
		System.out.println(new DetonateMaxBomb().maximumDetonation(bombs));
	}
	
	public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> g = IntStream.range(0, bombs.length).mapToObj(i -> new ArrayList<Integer>()).collect(Collectors.toList());

		for(int i = 0; i < bombs.length ; i++) {
			for(int j = 0; j < bombs.length; j++) {
				if(i!=j ) {
					// A^2 = B^2 + C^2
					double distance = Math.sqrt(Math.pow((bombs[i][0]-bombs[j][0]), 2) + Math.pow((bombs[i][1]-bombs[j][1]), 2));
					if(distance <= bombs[i][2]) {
						g.get(i).add(j);
					}
				}
			}
		}
		
		int r =0;
		for(int i =0; i < bombs.length ; i++) {
			r = Math.max(dfs(i, g, new boolean[bombs.length]), r);
		}
		
		
        return r;
    }
	
	private int dfs(int i,List<List<Integer>> adj,boolean []vis){
        vis[i]=true;
        int ans =1;
        for(int nd : adj.get(i)){
            if(!vis[nd])
                ans+=dfs(nd,adj,vis);
        }
        
        return ans;
    }

}
