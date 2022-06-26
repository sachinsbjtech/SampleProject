package com.sbj.nonlinearDS;

import java.util.Scanner;

public class ConnectedComponentsInGraph {

	/**
	 * Given n, i.e. total number of nodes in an undirected graph numbered from 1 to n and an integer e, i.e. total number of edges in the graph. Calculate the total number of connected components in the graph. A connected component is a set of vertices in a graph that are linked to each other by paths.

Input Format:

First line of input line contains two integers n and e. Next e line will contain two integers u and v meaning that node u and node v are connected to each other in undirected fashion. 

Output Format:

For each input graph print an integer x denoting total number of connected components.
	 */
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        int n = Integer.parseInt(name.split(" ")[0]);
        int e = Integer.parseInt(name.split(" ")[1]);
        
        int input[][] = new int[n][n];
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        while(e > 0){
        	name = s.nextLine();
            int u = Integer.parseInt(name.split(" ")[0]);
            int v = Integer.parseInt(name.split(" ")[1]);
            input[u - 1][v - 1]=1;
            input[v - 1][u - 1]=1;
            e--;
        }
        countConnectedComponents(input, n );
        
	}

	private static void countConnectedComponents(int[][] input, int totalNodes) {
		boolean visited[] = new boolean[totalNodes];
		int count =0;
		for(int i =0; i < input.length; i++) {
			if(!visited[i]) {
				dfs(i, visited, input);
				count++;
			}
		}
		System.out.println(count);
	}

	private static void dfs(int i, boolean[] visited, int input[][]) {
		visited[i]=true;
		for(int j =0; j < input[i].length; j++) {
			if(input[i][j]==1 && !visited[j]) {
				dfs(j, visited, input);
			}
		}
	}

}
