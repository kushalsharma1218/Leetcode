/*
Going with the problem and removing elements fom both sides we are not able to decide which element to choose. We are feeling directionless rightnow. In this case we need to rething about question and find sowm other way int his case it is

find max subarray with sum = totalsum  =. x + sumsubarray

*/
class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int n = nums.length;
        int maxi = -1;
        int left = 0;
        int current = 0;

        // sum([left ,..., right]) = total - x
        for (int right = 0; right < n; right++) {
            current += nums[right];
            while (current > total - x && left <= right) {
                current -= nums[left];
                left += 1;
            }
            
            if (current == total - x) {
                maxi = Math.max(maxi, right - left + 1);
            }
        }
        return maxi != -1 ? n - maxi : -1;
    }
}