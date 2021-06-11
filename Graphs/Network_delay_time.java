class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
  
        
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n+1;i++)
        {
            adj.add(i, new ArrayList<>());
        }
        
        for(int i = 0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            
            adj.get(u).add(new Pair(v, wt));
        }
        int dis[] = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        
        dis[k] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>(n, new Pair());
        queue.add(new Pair(k, 0));
        
        while(!queue.isEmpty())
        {
            Pair curr = queue.poll();
            
            int node = curr.v;
            
            for(Pair p: adj.get(node))
            {
                if(dis[p.v] > dis[node] + p.wt)
                {
                    dis[p.v] = dis[node] + p.wt;
                    queue.add(new Pair(p.v, dis[p.v]));
                }
            }
        }
        
        
        int max = 0;
        for(int i = 1;i<=n;i++)
        {
            if(dis[i] == Integer.MAX_VALUE)return -1;
            else max = Math.max(dis[i], max);
        }
        
        return max;
    }
}
class Pair implements Comparator<Pair>
{
  
    int v;
    int wt;
    
    Pair(){}
    
    Pair(int v, int wt)
    {
        
        this.v = v;
        this.wt = wt;
    }
    
    public int compare(Pair p1, Pair p2)
    {
        return p1.wt - p2.wt; 
    }
    
    
    
}