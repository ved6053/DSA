package geeksforgeeks.graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgorithm {
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u , int v) {
		adj.get(u).add(v);
		
	}
	
	private static ArrayList<ArrayList<Integer>> reverseEdges(ArrayList<ArrayList<Integer>> adj, int V) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(V);
	
		for(int i=0;i<V;i++) {
			res.add(new ArrayList<Integer>());
		}
		
		for(int u=0;u<V;u++){ 
			for(int v:adj.get(u)) {
				addEdge(res,v,u);
			}
		}
		return res;
	}
	
	private static void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, Stack<Integer> st) {
		visited[s]=true;
		st.push(s);
		for(int u:adj.get(s)) {
			if(visited[u]==false) {
				dfs(adj, u, visited,st);
			}
		}
	}
	
	private static void kosaraju(ArrayList<ArrayList<Integer>> adj,int V) {
		adj = reverseEdges(adj, V);
		boolean visited[] = new boolean[V];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<V;i++) {
			if(visited[i]==false) {
				dfs(adj, i, visited, st);
				while(!st.isEmpty())
					System.out.print(st.pop()+" ");
				System.out.println();
			}
		}
		
	}
	public static void main(String args[]) {
		int V = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj, 0, 1);
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 0);
		addEdge(adj, 3, 4);
		addEdge(adj, 4, 5);
		addEdge(adj, 5, 4);
		kosaraju(adj,V);
		
	}
}
