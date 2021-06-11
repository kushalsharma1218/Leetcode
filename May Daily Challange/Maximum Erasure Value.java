class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        int n = nums.length;
        while(end < n)
        {
            if(!set.contains(nums[end]))
            {
                set.add(nums[end]);
                sum += nums[end];
                end++;
                max = Math.max(max, sum);
            }
            else{
                while(start < end && set.contains(nums[end]))
                {
                    set.remove(nums[start]);
                    sum -= nums[start++];
                }
            }
            
        }
        
        return max;
    }
}