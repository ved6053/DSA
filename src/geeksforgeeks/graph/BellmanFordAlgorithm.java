package geeksforgeeks.graph;

import java.util.Arrays;

public class BellmanFordAlgorithm {
	private static int[] bellman(int graph[][], int V, int s) {
		int d[]= new int[V];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[s] = 0;
		for(int count=0;count<V-1;count++) {
			for(int u=0;u<V;u++)
				for(int v=0;v<V;v++)
					if(graph[u][v]!=0)
						d[v]=Math.min(d[v], d[u]+graph[u][v]);
		}
		
		for(int u=0;u<V;u++)
			for(int v=0;v<V;v++)
				if(graph[u][v]!=0&&(d[v]> d[u]+graph[u][v])) {
					 System.out.println("Negative weight cycle found");
					}

	 return d;
	}
	public static void main(String args[]) {
		int V = 4;
		char vertex[] = {'A', 'B', 'C', 'D'};
		
		int graph[][] = {
				{0, 1, 4, 0},
				{0, 0, -3, 2},
				{0, 0, 0, 3},
				{0, 0, 0, 0}
		};
		
		int d[]=bellman( graph, V, 0);
		for(int i=0;i<V;i++) {
			System.out.println(vertex[i]+" : "+d[i]);
		}
		
	}

}
