package geeksforgeeks.graph;


import java.util.Arrays;
import java.util.Stack;

public class ShortestPathInDAG {
	
	private static void  dfs(int[][] weight, int u ,boolean visited[] , Stack<Integer> st) {
		visited[u] = true;
		for(int v=0; v<weight.length;v++) {
			if(weight[u][v]==Integer.MAX_VALUE)
				continue;
			if(visited[v] == false)
				dfs(weight, v, visited, st);
			
		}
	   st.push(u);
	}
	
	private static Stack<Integer> topologicalSort(int[][] weight, int V) {
		Stack<Integer> st = new Stack<>();
		boolean visited[] = new boolean[V];
		for(int v=0;v<V;v++) {
			if(visited[v] == false) {
				dfs(weight, v, visited ,st);
			}
		}	
		
		return st;
		
	}
	
	private static void shortestPath(int weight[][], int V, int s) {
		
		int dist[] = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		
		Stack<Integer> st=topologicalSort(weight, V);
		while(!st.isEmpty()) {
			int u = st.pop();
			for(int v=0;v<V;v++) {
				if(weight[u][v]==Integer.MAX_VALUE)
					continue;
				if(dist[v]>dist[u]+weight[u][v])
					dist[v] = dist[u]+weight[u][v];
			}
		}
		
		for(int u=0;u<V;u++)
			System.out.print(dist[u] + " ");
		
	}
	
	

	public static void main(String args[]) {
		
		int V = 6;
		int weight[][] = new int[V][V];
		for(int u=0;u<V;u++)
			Arrays.fill(weight[u], Integer.MAX_VALUE);
		
		weight[0][1] = 2;
		weight[0][4] = 1;
		weight[1][2] = 3;
		weight[4][2] = 2;
		weight[4][5] = 4;
		weight[2][3] = 6;
		weight[5][3] = 1;
		
		System.out.println("Shortest Path In Dag , source="+0);
		shortestPath(weight, V, 0);
		
	}

}
