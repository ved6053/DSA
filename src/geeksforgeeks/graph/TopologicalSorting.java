package geeksforgeeks.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {

	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u , int v) {
		adj.get(u).add(v);
	}
	
	
	private static void  dfs(ArrayList<ArrayList<Integer>> adj, int u ,boolean visited[] , Stack<Integer> st) {
		visited[u] = true;
		for(int v : adj.get(u)) {
			if(visited[v] == false)
				dfs(adj, v, visited, st);
			
		}
	   st.push(u);
	}
	
	private static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
		Stack<Integer> st = new Stack<>();
		boolean visited[] = new boolean[V];
		for(int v=0;v<V;v++) {
			if(visited[v] == false) {
				dfs(adj, v, visited ,st);
			}
		}	
		
		while(!st.isEmpty()) {
			System.out.print(st.pop()+" ");
		}
	}
	
	public static void main(String args[]) {
		int V=6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 1, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 3, 5);
		
		System.out.println("Topological Sorting :");
		topologicalSort(adj, V);
	}
}
