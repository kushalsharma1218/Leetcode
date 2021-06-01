class Solution {
    public int totalNQueens(int n) {
        int arr[][]= new int[n][n];
        return nQueen(n,arr, 0);
    }
    public int nQueen(int n ,int arr[][], int col)
    {
        //base case
        if(col == n)
        {
            return 1;
        }
        else if(col > n)return 0;
        
        int count = 0;
        for(int i = 0;i<n;i++)
        {
            if(isCheck(arr, i, col))
            {
                arr[i][col] = 1;
                count = count + nQueen(n, arr, col+1);
                arr[i][col] = 0;
            }
        }
        
        return count;
        
    }
    public boolean isCheck(int arr[][], int row, int col)
    {
        int r = row;
        int c = col;
        
        
        while(c >=0)
        {
            if(arr[r][c] == 1)return false;
            c--;
        }
        
        
        r = row;
        c = col;
        
        while(r>=0 && c>=0)
        {
            if(arr[r][c] == 1)return false;
            r--;
            c--;
        }
        
        r = row;
        c = col;
        while(r < arr.length && c >=0)
        {
            if(arr[r][c] == 1)return false;
            r++;
            c--;
        }
        
        return true;
    }
}