/*
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
*/

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> lastIndexMap = new HashMap<>();
        int[] prefixSum = new int[n + 1];

        int result = 0, start = 0;
        for (int end = 0; end < n; end++) {
            int currentElement = nums[end];
            prefixSum[end + 1] = prefixSum[end] + currentElement;
            if (lastIndexMap.containsKey(currentElement)) {
                start = Math.max(start, lastIndexMap.get(currentElement) + 1);
            }
            // update result with maximum sum found so far
            result = Math.max(result, prefixSum[end + 1] - prefixSum[start]);
            lastIndexMap.put(currentElement, end);
        }
        return result;
    }
}