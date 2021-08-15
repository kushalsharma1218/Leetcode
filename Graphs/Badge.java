import java.util.*;
class A
{
	public static void main(String ar[])
	{
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		
		List<List<Integer>> graph = new ArrayList<>();
		
		for(int i = 0;i<=n;i++){
			graph.add(i, new ArrayList<>());
		}
		
		for(int i =0;i<n;i++)
		{
			graph.get(i+1).add(sc.nextInt());
		}
		
		
		for(int i = 1;i<=n;i++)
		{
			int vis[] = new int[n+1];
			dfs(i, graph, vis);
		}
		System.out.println();
	}
	public static void dfs(int node, List<List<Integer>> graph, int vis[])
	{
		
		if(vis[node] == 1)
		{
			System.out.print(node+" ");
			return;
		}
		else
		{
			vis[node] =1;
			dfs(graph.get(node).get(0), graph, vis);
			
		}
		
		
		
	}
}