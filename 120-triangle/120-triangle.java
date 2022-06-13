/*
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][];
        
        for(int i = 0;i<n;i++){
            dp[i] = new int[triangle.get(i).size()];
            Arrays.fill(dp[i], -1);
        }
        return findMinPathSum(0,0, triangle, dp);
    }
    public int findMinPathSum(int row, int col, List<List<Integer>> triangle, int dp[][])
    {
        if(row >= triangle.size() || col >= triangle.get(row).size()){
            return 0;
        }
        if(dp[row][col] != -1)return dp[row][col];
        
        int left = findMinPathSum(row+1, col, triangle, dp);
        int right = findMinPathSum(row+1, col+1, triangle, dp);
        
        return dp[row][col] = Math.min(left, right)+triangle.get(row).get(col);
        
    }
}
*/


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 1)return triangle.get(0).get(0);
        int dp[][] = new int[n][];
        
        for(int i = 0;i<n;i++){
            dp[i] = new int[triangle.get(i).size()];
        }
        
        dp[0][0] = triangle.get(0).get(0);
        int minPathSum = Integer.MAX_VALUE;
        for(int row = 1;row<n;row++){
            for(int col = 0;col<triangle.get(row).size();col++)
            {
                dp[row][col] = triangle.get(row).get(col);
                if(col == 0){
                    dp[row][col] = dp[row][col] + dp[row-1][col];
                }
                else if(col == triangle.get(row).size() -1){
                    dp[row][col] = dp[row][col] + dp[row-1][col-1];
                }
                else{
                    dp[row][col] = Math.min(dp[row][col] + dp[row-1][col], dp[row][col] + dp[row-1][col-1]);
                }
                
                if(row == n-1){
                    minPathSum = Math.min(minPathSum, dp[row][col]);
                }
            }
        }
        return minPathSum;
        
    }
}
