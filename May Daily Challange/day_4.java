class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        boolean canModify = true;
        for(int i = n-1;i>0;i--)
        {
            if(nums[i] < nums[i-1] && canModify)
            {
                if(i == n-1)
                {
                    canModify = false;
                    continue;
                }
                else if(nums[i+1] >= nums[i-1])
                {
                    nums[i] = nums[i+1];
                }
                else
                {
                    nums[i-1] = nums[i];
                }
                canModify = false;
                
            }
            
            else if(nums[i] < nums[i-1] && canModify == false)return false;
            
        }
        
        return true;
        
    }
}