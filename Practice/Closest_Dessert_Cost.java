class Solution {
     int totalDiff = Integer.MAX_VALUE;
     int closestCost = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
       
        
        for(int base : baseCosts)
        {
            choose(toppingCosts, 0, base, target);
        }
        return closestCost;
    }
    public void choose(int arr[] ,int index, int cost, int target)
    {
        //base
        int diff = Math.abs(target - cost);
        if(totalDiff >= diff)
        {
            if(totalDiff == diff)
            {
                closestCost = Math.min(closestCost, cost);
            }
            else closestCost = cost;
            totalDiff = diff;
            
        }
        
        if(index >= arr.length || cost > target)
        {
            return;
        }
        
        
        
        //0 ,1, 2
        choose(arr,index+1,cost,target);
        choose(arr, index+1, cost+arr[index],target);
        choose(arr, index+1, cost + 2*arr[index], target);
    }
}