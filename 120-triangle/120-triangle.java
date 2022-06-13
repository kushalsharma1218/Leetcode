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
        List<Integer> prevRow = triangle.get(0);
        for (int row = 1; row < triangle.size(); row++) {
            List<Integer> currRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                int smallestAbove = Integer.MAX_VALUE;           
                if (col > 0) {
                    smallestAbove = prevRow.get(col - 1);
                } 
                if (col < row) {
                    smallestAbove = Math.min(smallestAbove, prevRow.get(col));
                }
                currRow.add(smallestAbove + triangle.get(row).get(col));
            }
            prevRow = currRow;
        }
        return Collections.min(prevRow);
    }
}