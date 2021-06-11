class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int n =grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        
        int max= 0 ;
        
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(vis[i][j] == 0 && grid[i][j] == 1)
                {
                    max = Math.max(dfs(i, j, grid, vis), max);
                }
            }
        }
        return max;
    }
    public int dfs(int row, int col, int arr[][], int vis[][])
    {
        //base cases
        if(row < 0 || col <0 || row>=arr.length || col >= arr[0].length)return 0;
        if(vis[row][col] == 1)return 0;
        if(arr[row][col] != 1)return 0;
        
        
        
        vis[row][col] = 1;
        int left = dfs(row, col-1, arr, vis);
        
        int right = dfs(row, col+1,arr,vis);
        
        int up = dfs(row-1, col, arr, vis);
        
        int down = dfs(row+1, col, arr, vis);
        
        
        return left + right + up+ down +1;
        
    }
}