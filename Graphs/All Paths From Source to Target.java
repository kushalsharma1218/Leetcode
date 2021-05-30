class Solution {
    int n = 0;
    int graph[][];
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n= graph.length;
        this.graph = graph;
        List<List<Integer>> ans= new ArrayList<>();

        dfs(0,ans, new ArrayList<Integer>());
        
        
        return ans;
    }
    public void dfs(int node, List<List<Integer>> ans, List<Integer> list)
    {
 
        list.add(node);

        if(node == n-1)
        {
            ans.add(new ArrayList<Integer>(list));
            list.remove(list.size() -1);
            return;
        }
        
        
        for(int j= 0;j<graph[node].length;j++)
        {
            dfs(graph[node][j], ans, list);
                  
            
        }
        
        list.remove(list.size() -1);
    
        return;
    }
}