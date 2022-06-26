class Solution {
    public void rotate(int[][] matrix) {
        //transapose then reverse every column
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int i = 0;
        int j = m-1;
        while(i < j){
            int temp[] = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
        
        for(i = 0;i<n;i++){
            for(j = i+1;j<m;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
    }
}