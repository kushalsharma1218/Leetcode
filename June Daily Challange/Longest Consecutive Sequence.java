class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        
        for(int i = 0;i<nums.length;i++)
        {
            if(set.contains(nums[i] - 1))continue;
            int num = nums[i] +1;
            int currLen = 1;
            while(set.contains(num))
            {
                currLen++;
                num += 1;
            }
            
            ans = Math.max(currLen, ans);
        }
        return ans;
    }
}