class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = 0;
        int end = 0;
        int n = nums.length;
        int max = nums[0];
        int ans = 0;
        int windowSize = 0;
        while(end < n)
        {
            if(nums[end] < left)
            {
                ans += windowSize;
                
            }
            else if(nums[end] > right)  
            {
                start = end+1;
                if(start == n)break;
                max = nums[start];
                windowSize = 0;
                
            }
            else{
                max = Math.max(nums[end],max);
                windowSize = end - start +1;
                ans += windowSize;
            }
            end++;
        }
        return ans;
    }
}