class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n < 2)return 0;
        
        // using peigieon hole principle
        //first find the interval
        
        int min = nums[0];
        int max = 0;
        
        for(int i  = 0;i<n;i++)
        {
            min = Math.min(nums[i], min);
            max = Math.max(max, nums[i]);
        }
        
        int interval = (int)Math.ceil((max - min + 0.0)/(n-1));
        
        //second step is to build our buckets
        //the bucket size will alwys be less than n so its n-1
        int bucketMin[] = new int[n-1];
        int bucketMax[] = new int[n-1];
        
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, -1);
        
        for(int i = 0;i<n;i++)
        {
            if(nums[i] == min || nums[i] == max)continue;
            
            int index = (nums[i] - min)/ interval;
            
            bucketMin[index] = Math.min(bucketMin[index], nums[i]);
            bucketMax[index] = Math.max(bucketMax[index], nums[i]);


        }
        
        
        // upto here we have figured out max and min for each bucket
        // take min for first bucket
        int prev = min;
        int ans = 0;
        for(int i = 0;i<n-1;i++)
        {
            if(bucketMax[i]==-1)continue;
            ans = Math.max(ans, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
       
        ans = Math.max(ans, max - prev);
        return ans;
    }
}