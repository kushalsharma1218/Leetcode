/*
Find (n-k) length subarray that has min sum

*/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        int minSum = 0;
        int curr = 0;
        
        int windowSize = cardPoints.length - k;
        for(int i = 0;i<windowSize;i++){
            total += cardPoints[i];
            curr += cardPoints[i];
        }
        minSum = curr;
        
        for(int i = windowSize;i<cardPoints.length;i++){
            curr -= cardPoints[i-windowSize];
            curr += cardPoints[i];
            
            minSum = Math.min(curr, minSum);
            total += cardPoints[i];
        }
        
        return total - minSum;
    }
}