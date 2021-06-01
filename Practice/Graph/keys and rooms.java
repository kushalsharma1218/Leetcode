class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[] = new boolean[rooms.size()];
        
        dfs(0, rooms, vis);
        
        
        for(int i  =0;i<rooms.size();i++)
        {
            if(vis[i] == false)return false;
        }
        return true;
    }
    public void dfs(int node, List<List<Integer>> adj, boolean vis[])
    {
        vis[node] = true;
        
        for(int i: adj.get(node))
        {
            if(vis[i] == false)
            {
                dfs(i, adj, vis);
            }
        }
    }
}