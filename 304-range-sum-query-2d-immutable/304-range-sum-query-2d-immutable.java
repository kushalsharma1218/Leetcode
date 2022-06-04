class NumMatrix {
    int arr[][];
    public NumMatrix(int[][] matrix) {
        arr = matrix;
        buildPrefix();
    }
    
    public void buildPrefix(){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                int num = arr[i][j];
                if(i > 0){
                    num += arr[i-1][j];
                }
                if(j > 0){
                    num += arr[i][j-1];
                }
                
                if(i > 0 && j>0){
                    num -= arr[i-1][j-1];
                }
                
                arr[i][j] = num;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = arr[row2][col2];
        if(row1 > 0){
            sum -= arr[row1-1][col2];
        }
        if(col1 > 0){
            sum -= arr[row2][col1-1];
        }  
        
        if(row1 > 0 && col1 > 0){
            sum += arr[row1-1][col1-1];
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */