class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int arr[][] = new int[n][2];
        
        for(int i = 0;i<n;i++)
        {
            arr[i][0] = speed[i];
            arr[i][1] = efficiency[i];
        }
        
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a,b) -> a- b);
        long speedSum = 0;
        long ans = 0;
        for(int i = 0;i<n;i++)
        {
            int currSpeed = arr[i][0];
            int curreff = arr[i][1];
            
            //first check size > k-1
            while(queue.size() > k-1)
            {
               speedSum -= queue.remove(); 
            }
            
            
            queue.add(currSpeed);
            
            speedSum += currSpeed;
            
            ans = Math.max(ans, speedSum * curreff);
        }
        
        return (int)(ans%1000000007);
        
    }
}