class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length -1;
        while(i > 0 && nums[i] <= nums[i-1])
        {
            i--;
        }
        if(i > 0){
            i--;
            int j = nums.length -1;
            while(j > i && nums[j] <= nums[i]){
                j--;
            }
            
            swap(i, j, nums);
            reverse(i+1, nums.length -1, nums);
        }
        else{
            reverse(0, nums.length -1, nums);
        }
    }
    public void reverse(int i, int j, int nums[])
    {
        while(i < j){
            swap(i, j, nums);
            i++;
            j--;
        }
    }
    public void swap(int i, int j, int arr[])
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}