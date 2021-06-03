package geeksforgeeks.graph;

import java.util.Arrays;

public class PrimsAlgorithm {
	
	private static int primsMST(int graph[][], int V) {
		int key[] = new int[V];
		int res = 0;
		Arrays.fill(key, Integer.MAX_VALUE);
		key[0] = 0;
		boolean mset[] = new boolean[V];
		
		for(int count =0; count<V; count++) {
			int u=-1;
			
			for(int i=0;i<V;i++) 
				if(!mset[i] && (u==-1 || key[i]<key[u])) 
					u = i;
				   
	        
			mset[u] = true;
		    res+=key[u];	
		    
		    System.out.println(key[u]+":"+u);
		    
		    for(int v=0;v<V;v++) {	
				if(graph[u][v]!=0&&!mset[v])
					key[v]= Math.min(key[v], graph[u][v]);
			}
			
			
		}
		return res;
	}
	
	public static void main(String args[]) {
		
		int V=5;
		int graph[][] = {
				{0, 2, 0, 6, 0},
				{2, 0, 3, 8, 5},
				{0, 3, 0, 0, 7},
				{6, 8, 0, 0, 9},
				{0, 5, 7, 9, 0}
				};
		
		System.out.println("Weight of Minimum spanning tree:"+primsMST(graph, V));
	}

}
