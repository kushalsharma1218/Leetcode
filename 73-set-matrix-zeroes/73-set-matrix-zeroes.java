/*
public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(matrix[i][j] == 0)
                {
                    for(int k = 0;k<n;k++)
                    {
                        if(matrix[k][j] != 0){
                            matrix[k][j] = -1;
                        }
                    }
                    
                    for(int k = 0;k<m;k++)
                    {
                        if(matrix[i][k] != 0){
                            matrix[i][k] = -1;
                        }
                    }
                }
            }
        }
        
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(matrix[i][j] == -1)matrix[i][j] = 0;
            }
        }
       
    }
    
    
    // app 2
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean col[] = new boolean[m];
        boolean row[] = new boolean[n];
        
        
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(matrix[i][j] == 0){
                    col[j] = true;
                    row[i] = true;
                }
            }
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(col[j] || row[i])matrix[i][j] = 0;
            }
        }
        
    }
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean col = true;
        
        for(int i = 0;i<n;i++)
        {
            if(matrix[i][0] == 0)col = false;
            for(int j = 1;j<m;j++)
            {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = n-1;i >= 0;i--)
        {
            for(int j = m-1;j>=1;j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            
            if(!col){
                matrix[i][0] = 0;
            }
        }
        
    }
}