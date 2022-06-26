package com.sbj.nonlinearDS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSAlgorithm {
	
	int vertices ;
	LinkedList<Integer> list[] ;
	
	
	DFSAlgorithm(int vertices){
		this.vertices = vertices;
		list = new LinkedList[vertices];
		for(int i = 0; i< vertices; i++) {
			list[i] = new LinkedList<Integer>();
		}
	}
	
	void DFS(int prentNode){
		boolean visited[] = new boolean[vertices];
		
		DFSUtil(prentNode, visited);
	}
	
	void DFSUtil(int vertice, boolean visited[]) {
		
		visited[vertice] = true;
		System.out.println("Visited Item : "+ vertice);
		Iterator<Integer> iterator = list[vertice].listIterator();
		
		
		while(iterator.hasNext()) {
			int next = iterator.next();
			if(!visited[next]) {
				DFSUtil(next, visited);
			}
		}
		
	}
	
	void addEdge(int v, int edge) {
		list[v].add(edge);
	}

	public static void main(String[] args) {
		DFSAlgorithm g = new DFSAlgorithm(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.DFS(2);
	}

}
