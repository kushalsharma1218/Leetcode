class Solution {
    public int maxScore(int[] arr, int k) {
       
        int n = arr.length;
        int sum = 0;
        for(int i = n-k;i<n;i++)
        {
            sum += arr[i];
        }
        if(k == n)return sum;
        int max = sum;
        int start = n-k;
        int end = 0;
        while(start < n && end < k)
        {
            sum += arr[end];
            sum -= arr[start];
       
            max = Math.max(sum, max);
            end++;
            start++;
            
        }
        return max;
    }
}