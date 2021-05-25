class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return minJumps(nums, 0, dp);
    }
    
    public int  minJumps(int arr[] , int i, int dp[])
    {
        //base cases
        if(i >= arr.length-1)return 0;
        if(dp[i] != -1)return dp[i];
        int step = Integer.MAX_VALUE;
        int num = arr[i];
        for(int j = 1;j<= num;j++)
        {
            step = Math.min(step, minJumps(arr, i+j, dp));
        }
        
        
        return dp[i] = step == Integer.MAX_VALUE? step:step +1;
    }
}