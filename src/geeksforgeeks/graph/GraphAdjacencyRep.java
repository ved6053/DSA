package geeksforgeeks.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAdjacencyRep {
	
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u , int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	private static void printGraph(ArrayList<ArrayList<Integer>> adj, int v) {
		for(int i=0;i<adj.size();i++) {
			System.out.print(i+"->");
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print(adj.get(i).get(j)+" ");
			}
			
			System.out.println();
		}
	}
	
	private static int  bfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean hasPrint) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[s] = true;
		q.add(s);
		int count=0;
		while(q.isEmpty()==false) {
			int u=q.poll();
			if(hasPrint)
				System.out.print(u+" ");
			count++;
			for(int v:adj.get(u)) {
				if(visited[v]==false) {
					visited[v] = true;
					q.add(v);
				}
			}
		}
		return count++;
	}
	
	private static int bfsDis(ArrayList<ArrayList<Integer>> adj, int V, boolean hasPrint) {
		boolean visited[] = new boolean[V+1];
		int count=0;
		for(int i=0;i<V;i++) {
			if(visited[i]==false) {
				count+=bfs(adj, i, visited, hasPrint);
			}
		}
		return count;
	}
	
	private static void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
		visited[s]=true;
		System.out.print(s+" ");
		for(int u:adj.get(s)) {
			if(visited[u]==false) {
				dfs(adj, u, visited);
			}
		}
	}
	
	private static void dfsDis(ArrayList<ArrayList<Integer>> adj,int V) {
		boolean visited[] = new boolean[V+1];
		for(int i=0;i<V;i++) {
			if(visited[i]==false) {
				dfs(adj, i, visited);
			}
		}
		
	}
	
	private static int graphLength(ArrayList<ArrayList<Integer>> adj,int V ){
		return bfsDis(adj, V, false);
	}
	
	private static int connectedComponent(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean visited[] = new boolean[V+1];
		int count=0;
		for(int i=0;i<V;i++) {
			if(visited[i]==false) {
				bfs(adj, i, visited, true);
				System.out.println();
				count++;
			}
		}
		return count;
		
	}
	
	
	public static void main(String args[]) {
		int V=8;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 0, 5);
		addEdge(adj, 1, 3);
		addEdge(adj, 2, 4);
		addEdge(adj, 3, 5);
		addEdge(adj, 4, 5);
		addEdge(adj, 6, 7);
		System.out.println("Print adjancency list of graph:");
		printGraph(adj, V);
		System.out.println();
		System.out.println("Print BFS traversal of graph:");
		bfsDis(adj, V, true);
		System.out.println();
		System.out.println("Print DFS traversal of graph:");
		dfsDis(adj, V);
		System.out.println();
		System.out.println("Connected component of graph:");
		System.out.println("Number of Connected component of graph:"+connectedComponent(adj, V));
		
	}

}
