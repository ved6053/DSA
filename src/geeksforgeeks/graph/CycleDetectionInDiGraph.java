package geeksforgeeks.graph;

import java.util.ArrayList;

//Detect Cycle in Directed graph using dfs
public class CycleDetectionInDiGraph {

	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u , int v) {
		adj.get(u).add(v);
	}
	
	private static boolean dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[],boolean recSt[])
	{
		visited[s] = true;
		recSt[s] = true;
		for(int u : adj.get(s)) {
			if(visited[u] == false && dfsRec(adj, u, visited, recSt))
				return true;
			else if(recSt[u]==true)
				return true;
		}
		
		recSt[s] = false;
		return false;
	}
	
	private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean visited[] = new boolean[V];
		boolean recSt[] = new boolean[V];
		
		for(int i=0;i<V;i++) {
			if(visited[i]==false)
				if(dfsRec(adj, i, visited, recSt)==true)
					return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		int V=6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj, 0, 1);
		addEdge(adj, 2, 1);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 4, 5);
		addEdge(adj, 5, 3);
		
		System.out.println("Is Cycle Detected:"+dfs(adj,V));
		
		V=4;
	    adj = new ArrayList<ArrayList<Integer>>(V);
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj, 0, 1);
		addEdge(adj, 2, 1);
		addEdge(adj, 2, 3);
		addEdge(adj, 1, 3);
	
		System.out.println("Is Cycle Detected:"+dfs(adj,V));
		
		
					
	}

}
