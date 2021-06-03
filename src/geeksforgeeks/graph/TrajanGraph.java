package geeksforgeeks.graph;


import java.io.*; 
import java.util.*; 
import java.util.LinkedList; 


class TrajanGraph 
{ 
	private int V; 
 
	private LinkedList<Integer> adj[]; 
	int time = 0; 
	static final int NIL = -1; 

	TrajanGraph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	void addEdge(int v, int w) 
	{ 
		adj[v].add(w);  
	} 
 
	void  tarjanUtil(int u, boolean visited[], int disc[], 
				int low[], int parent[], Stack<Integer> st) 
	{ 

		st.push(u);
		visited[u] = true; 

		disc[u] = low[u] = ++time; 

		Iterator<Integer> i = adj[u].iterator(); 
		while (i.hasNext()) 
		{ 
			int v = i.next(); 
			if (!visited[v]) 
			{ 
				parent[v] = u; 
				tarjanUtil(v, visited, disc, low, parent, st); 

		 
				low[u] = Math.min(low[u], low[v]); 
			} 

			else if (v != parent[u]) 
				low[u] = Math.min(low[u], disc[v]); 
		} 
	} 

	void tarjan() 
	{ 
		
		boolean visited[] = new boolean[V]; 
		int disc[] = new int[V]; 
		int low[] = new int[V]; 
		int parent[] = new int[V]; 
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < V; i++) 
		{ 
			parent[i] = NIL; 
			visited[i] = false; 
			
		} 
 
		for (int i = 0; i < V; i++) 
			if (visited[i] == false) 
				tarjanUtil(i, visited, disc, low, parent,st); 
		while(!st.isEmpty()){
			int u=st.pop();
			if(low[u]==disc[u])
				System.out.println(u+" ");
			else 
				System.out.print(u+" ");
		}
 
	} 

	public static void main(String args[]) 
	{ 
		System.out.println("Connected component using Trojan's Algorithm in graph "); 
		TrajanGraph g = new TrajanGraph(5); 
		g.addEdge(0, 1); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 4); 
		g.tarjan(); 
		System.out.println(); 
	} 
} 