class Solution {
    public int scheduleCourse(int[][] arr) {
        Arrays.sort(arr, (a,b) -> a[1] - b[1]);
        int totalTime = 0 ;
        int count = 0;
        int n  = arr.length;
        for(int i = 0;i<n;i++)
        {
            if(totalTime + arr[i][0] > arr[i][1])continue;
            totalTime += arr[i][0];
            count++;
        }
        return count;
    }
}