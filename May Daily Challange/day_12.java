class NumMatrix {
    int mat[][];
    public NumMatrix(int[][] matrix) {
        mat = matrix;
        preSum();
    }
    public void preSum()
    {
        for(int i=1;i<mat.length;i++)
        {
            mat[i][0] += mat[i-1][0];
        }
        
        for(int j = 1;j<mat[0].length;j++)
        {
            mat[0][j]  += mat[0][j-1];
        }
        
        for(int i =1;i<mat.length;i++)
        {
            for(int j= 1;j<mat[i].length;j++)
            {
                int sum = 0;
                sum += mat[i-1][j];
                sum += mat[i][j-1];
                sum -= mat[i-1][j-1];
                
                
                mat[i][j] += sum;
            }
        }
   }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int sum = 0;
        
        sum += mat[row2][col2];
        if(row1 - 1 >= 0)
        {
            sum -= mat[row1-1][col2];
        }
        if(col1-1 >=0)
        {
            sum -= mat[row2][col1 - 1];
        }
        if(col1 >0 && row1 > 0)
        {
            sum += mat[row1 -1][col1 -1];
        }
        
        return sum;
    }
}
