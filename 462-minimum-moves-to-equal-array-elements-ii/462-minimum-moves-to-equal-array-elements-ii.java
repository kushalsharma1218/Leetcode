/*
Checking for every number through sorting


public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        long min = Long.MAX_VALUE, sum = 0, total = 0;
        for (int num : nums) {
            total += num;
        }
        for (int i = 0; i < nums.length; i++) {
            long ans = ((long) nums[i] * i - sum) + ((total - sum) - (long) nums[i] * (nums.length - i));
            System.out.println(nums[i] + " " + ans);
            min = Math.min(min, ans);
            sum += nums[i];
        }
        return (int) min;
    }
}

*/

public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ele = nums[nums.length / 2];
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(ele - num);
        }
        return sum;
    }
}
