class Solution {
    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> queries) {
        //represent the equations in form of graph
        
        HashMap<String, List<Node>> map = new HashMap<>();
        for(int i = 0;i<eq.size();i++)
        {
            if(!map.containsKey(eq.get(i).get(0)))map.put(eq.get(i).get(0), new ArrayList<>());
            map.get(eq.get(i).get(0)).add(new Node(eq.get(i).get(1), values[i]));
            
            if(!map.containsKey(eq.get(i).get(1)))map.put(eq.get(i).get(1), new ArrayList<>());
            map.get(eq.get(i).get(1)).add(new Node(eq.get(i).get(0), 1/ values[i]));
            
        }
        
        System.out.println(map);
        double ans[] = new double[queries.size()];
        for(int i =0;i< queries.size();i++)
        {
            String src = queries.get(i).get(0);
            String des = queries.get(i).get(1);
            if(!map.containsKey(src))
            {   
                ans[i] = -1.0;
                continue;
            }
            double tans = dfs(src,des, map, new HashSet<String>());
            if(tans == 0)ans[i] = (double)-1;
            else ans[i] = tans;
        }
        return ans;
    }
    public double dfs(String src, String des, HashMap<String, List<Node>> map, Set<String> vis)
    {
        if(src.equals(des))return 1;
        if(vis.contains(src))return 0;
        
        vis.add(src);
        if(map.containsKey(src)){
        for(Node node : map.get(src))
        {
            String tempSrc = node.v;
            double val = node.wt;
            
            double tempAns = dfs(tempSrc, des, map, vis);
            
            if(tempAns == 0)continue;
            
            return tempAns * val;
            
        }
        }
        
        return 0;
        
    }
}
class Node
{
    String v;
    double wt;
    
    Node(String v, double wt)
    {
        this.v = v;
        this.wt = wt;
    }
    
    public String toString()
    { 
        return v + " "+ wt;
    }
}