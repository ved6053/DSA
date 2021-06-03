package geeksforgeeks.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
	
	private static int[] shortestPath(int graph[][], int V, int s) {
		
		 int dist[] = new int[V];
		 Arrays.fill(dist, Integer.MAX_VALUE);
		 dist[s] = 0;
		 boolean fin[] = new boolean[V];
		
		for(int count=0;count<V-1;count++) {
			 int u = -1;
			 for(int i=0; i<V;i++) 
				 if(!fin[i]&&(u==-1||dist[i]<dist[u]))
					 u = i;
			 fin[u] = true;
			 
			 for(int v=0;v<V;v++) {
				 if(!fin[v]&&graph[u][v]!=0) {
					 //relax(u, v)
						 dist[v] = Math.min(dist[v], dist[u]+graph[u][v]);
				 }
				 
			 }
		 }
		return dist;
	}
	
	public static void main(String args[]) {
		
		int V = 9;
		char vertex[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
		int graph[][] = {
				{0, 4, 8,  0, 0, 0, 0, 0, 0},
				{4, 0, 11, 8, 0, 0, 0, 0, 0},
				{8, 11, 0, 0, 7, 1, 0, 0, 0},
				{0,  8, 0, 0, 2, 0, 7, 4, 0},
				{0,  0, 7, 2, 0, 6, 0, 0, 0},
				{0, 0, 1, 0, 6, 0,  0, 2, 0},
				{0, 0, 0, 7, 0, 0, 0, 14, 9},
				{0, 0, 0, 0, 0, 2, 14, 0, 10},
				{0, 0, 0, 0, 0, 0, 9, 10, 0},
				};
		
		int dist[] = shortestPath(graph, V, 0);
		
		for(int i=0;i<V;i++)
		{
			System.out.println(vertex[i]+":"+dist[i]);
		}
	}


}
