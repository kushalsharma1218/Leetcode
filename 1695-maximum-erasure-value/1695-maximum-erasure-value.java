class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        int currSum = 0;
        int s = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            while(set.contains(num))
            {
                currSum -= nums[s];
                set.remove(nums[s++]);
            }
            
            currSum += num;
            set.add(num);
            maxSum = Math.max(currSum, maxSum);
            
        }
        return maxSum;
    }
}