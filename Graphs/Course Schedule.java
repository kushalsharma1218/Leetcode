class Solution {
    List<Integer> adj[] = new ArrayList[100005];
    public boolean canFinish(int numCourses, int[][] pre) {
        for(int i = 0;i<numCourses;i++)
        {
            adj[i]= new ArrayList<>();
        }
        
        
        for(int i = 0;i<pre.length;i++)
        {
            int u = pre[i][0];
            int v = pre[i][1];
            adj[v].add(u);
        }
        int vis[] = new int[numCourses];
        boolean res = false;
        for(int i = 0;i<numCourses;i++)
        {
            if(vis[i] == 0)
            {
                res = res | checkCycleInDG(i, vis, new int[numCourses]);
                if(res == true)return false;
            }
        }
        
        if(res)return false;
        else return true;
    }
    public boolean checkCycleInDG(int node, int vis[], int pathVis[])
    {
        vis[node] =1;
        pathVis[node] =1;
        
        for(int it: adj[node]){
            if(vis[it] == 0)
            {
                if(checkCycleInDG(it, vis, pathVis) == true)return true;
            }
            else if(pathVis[it] == 1)
            {
                return true;
            }
        }
        
        
        pathVis[node] = 0;
        return false;
    }
}