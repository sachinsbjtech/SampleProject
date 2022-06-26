package com.sbj.nonlinearDS;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFSImplementation {

	public static void main(String[] args) {
		Graph g = new DFSImplementation().new Graph(7);
		
		g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        
        boolean visited[] = new boolean[g.vertices];
        g.dfs(0, visited);
	}
	
	
	class Graph{
		int vertices;
		List<Integer> verticesList[];
		public Graph(int vertices) {
			this.vertices = vertices;
			verticesList = new LinkedList[vertices];
			for(int i =0; i < vertices; i++) {
				verticesList[i] = new LinkedList<Integer>();
			}
		}
		
		void addEdge(int vertice, int edge) {
			verticesList[vertice].add(edge);
		}
		
		Stack<Integer> dfsStack = new Stack<Integer>();
		public void dfs(int node, boolean[] visited) {
			
			dfsStack.push(node);
			// for initial Node
			visited[node] = true;
			
			while(!dfsStack.isEmpty()) {
				int currentNode = dfsStack.pop();
				System.out.println("Node:"+currentNode);
				List<Integer> childNodes = verticesList[currentNode];
				// want preOrder Traversal so put right most child node into Stack first 
				for(int i = childNodes.size() -1 ; i >=0; i--) {
					if(!visited[childNodes.get(i)]) {
						//dfsStack.push(childNodes.get(i));
						//visited[childNodes.get(i)] = true;
						dfs(childNodes.get(i), visited);
					}
				}
			}
		}
	}

}
