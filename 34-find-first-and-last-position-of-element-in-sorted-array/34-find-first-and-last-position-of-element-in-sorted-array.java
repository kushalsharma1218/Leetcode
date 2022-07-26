class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPos = find(nums, target);
        if(firstPos == -1)return new int[]{-1,-1};
        
        int lastPos = findLast(nums, target);
        return new int[]{firstPos, lastPos};
    }
    public int find(int nums[], int target)
    {
        int l = 0;
        int r = nums.length - 1;
        while(l <=r)
        {
            int m = (l+r)/2;
            if(nums[m] == target)
            {
                if(m >0 && nums[m-1] == target)r = m-1;
                else return m;
            }
            else if(nums[m] > target)
            {
                r = m  -1;
            }
            else l = m+1;
        }
        return -1;
    }
    public int findLast(int arr[], int tar)
    {
        int low = 0;
        int high = arr.length -1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(arr[mid] == tar)
            {
                if(mid < arr.length-1 && arr[mid +1] == tar)low = mid +1;
                else return mid;
            }
            else if(arr[mid] > tar)high = mid -1;
            else low = mid +1;
        }
        return -1;
    }
}