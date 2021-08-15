class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] q) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            graph.add(i , new ArrayList<>());
        }
        
        int len = pre.length;
        for(int i = 0;i<len;i++)
        {
            int u = pre[i][0];
            int v= pre[i][1];
            graph.get(u).add(v);
        }
        
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0;i<q.length;i++)
        {
            ans.add(dfs(q[i][0], q[i][1], new int[n], graph));
        }
        
        return ans;
    }
    public boolean dfs(int src, int des, int vis[], List<List<Integer>> graph)
    {
        vis[src] = 1;
        if(src == des)return true;
        
        for(Integer it : graph.get(src))
        {
            if(vis[it] == 0)
            {
                if(dfs(it, des, vis, graph) == true)return true;
            }
        }
        return false;
    }
}