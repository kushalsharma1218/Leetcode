class Pair{
    int v;
    int weight;
    
    Pair(int v, int weight)
    {
        this.v = v;
        this.weight = weight;
    }
}
class Solution 
{ 
    int solve(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        //create a residual graph
        int V = N;
        int graph[][] = new int[V+1][V+1];
        
        for(int i = 0;i<Edges.size();i++)
        {
            int u = Edges.get(i).get(0);
            int v = Edges.get(i).get(1);
            int wt = Edges.get(i).get(2);
            
            graph[u][v] = wt;
            graph[v][u] = wt;
       
        }
        
        // second step is find a path from src to sink and sore it in parnt array
        int src =1;
        int des = N;
        int max_flow = 0;
        int parent[] = new int[V+1];
        
        while(bfs(graph, src, des, parent))
        {
            //lest figure out the min residual on that path
            int path_flow = Integer.MAX_VALUE;
            for(int v = des; v != src ;v = parent[v])
            {
                int u = parent[v];
                path_flow = Math.min(path_flow, graph[u][v]);
            }
            
            // update the residual capacity
            for(int v = des; v != src ;v= parent[v])
            {
                int u = parent[v];
                graph[u][v] -= path_flow;
               
            }
            
            max_flow += path_flow;
            
            
        }
        return max_flow;
    }
    public boolean bfs(int resGraph[][], int src, int sink, int parent[]){
        boolean vis[] = new boolean[resGraph.length +1];
        
        int V = resGraph.length;
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(src);
        vis[src] = true;
        parent[src] = -1;
        
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            for(int v = 0;v <V;v++)
            {
                if(!vis[v] && resGraph[curr][v] > 0)
                {
                    
                    if(v == sink)
                    {
                        parent[v] = curr;
                        return true;
                    }
                    
                    parent[v] = curr;
                    queue.add(v);
                    vis[v]= true;
                }
            }
            
          
        }
       return false;
    }
}