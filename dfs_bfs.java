//DFS recursive implementation for unidirected graph

import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;
import java.util.Queue;

class Graph
{
	private LinkedList<Integer>[] adj;

	private int ver; //total no. of vertices in the graph
	private int edge; //total no. of edges in the graph
	
	//Constructor
	Graph(int ver,int edge)
	{
		this.ver=ver;
		this.edge=edge;
		adj=new LinkedList[ver];
		
		for(int i=0;i<adj.length;i++)
		{
			adj[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int u,int v)
	{
		this.adj[u].add(v);
		this.adj[v].add(u);
	}
	
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		sb.append(ver+" vertices, "+edge+" edges "+"\n");
		
		for(int i=0;i<ver;i++)//looping over every vertex
		{
			sb.append(i+" : -> "); 
			for(int w:adj[i])
			{
				sb.append(w+"-> ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void dfs()
	{
		boolean[] visited=new boolean[ver];
		
		for(int v=0;v<ver;v++)
		{
			if(!visited[v])
			{
				dfs(v,visited);
			}
		}
	}
	
	public void dfs(int v, boolean[] visited)
	{
		visited[v]=true;
		System.out.print(v+" -> ");
		
		for(int w: adj[v])
		{
				if(!visited[w])
				{
					dfs(w,visited);
				}
		}
	}
	
	public void bfs(int s)
	{
		boolean[] visit=new boolean[ver];
		Queue<Integer> q=new LinkedList<Integer>();
        visit[s] = true;
        q.add(s);
        BFSUtil(q, visit);
	}
	
	public void BFSUtil(Queue<Integer> q,boolean[] visit)
	{
		if(q.isEmpty())
		{
			return;
		}
		int vertex=q.poll();
		System.out.print(vertex+" -> ");
		for(int w: adj[vertex])
		{
			if(!visit[w])
			{
				visit[w]=true;
				q.add(w);
			}
		}
		
		BFSUtil(q,visit); 
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Please enter the no. of total vertices/nodes in the graph: ");
		int v=sc.nextInt();
		
		System.out.print("\nPlease enter the no. of total edges in the graph: ");
		int e=sc.nextInt();
		
		Graph graph=new Graph(v,e);
		
		for(int i=0;i<e;i++)
		{
			for(int j=i+1;j<v;j++)
			{
				System.out.print("\nDoes an edge exist between vertices "+i+" and "+j+" ? if yes enter 1 else 0: ");
				int ans=sc.nextInt();
				
				if(ans==1)
				{
					graph.addEdge(i,j);
				}
			}
		}
		System.out.println("\nThe Adjacency List Representation of the Graph is as follows:\n"+graph);
		
		System.out.println("The DFS traversal on above graph is as follows:");
		graph.dfs();
		
		System.out.println("\nThe BFS traversal on above graph is as follows:\n");
		graph.bfs(0);
	}
}