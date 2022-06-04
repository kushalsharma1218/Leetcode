class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        boolean chess[][] = new boolean[n][n];
        placeNQueens(chess, 0, list);
        return list;
    }
    public void placeNQueens(boolean chess[][], int col, List<List<String>> list)
    {
        if(col >= chess.length)
        {
            List<String> res = new ArrayList<>();
            
            for(int i = 0;i<chess.length;i++){
                StringBuffer sb = new StringBuffer();
                for(int j = 0;j<chess[i].length;j++){
                    if(chess[i][j]){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            
            list.add(res);
            return;
        }
        
        for(int row = 0;row<chess.length;row++)
        {
            chess[row][col] = true;
            if(isValid(chess, row, col)){
                placeNQueens(chess, col+1, list);
            }
            chess[row][col] = false;
        }
    }
    public boolean isValid(boolean chess[][], int row, int col)
    {
        int r = row -1;
        int c = col -1;
        
        //same row
        while(c >= 0)
        {
            if(chess[row][c])return false;
            c--;
        }
        
        //same col
        while(r >=0){
            if(chess[r][col])return false;
            r--;
        }
        
        //upper diagonal
        r = row-1;
        c = col-1;
        
        while(r >= 0 && c >= 0){
            if(chess[r][c])return false;
            r--;
            c--;
        }
        
        r = row+1;
        c = col-1;
        
        while(r < chess.length && c >= 0){
            if(chess[r][c])return false;
            r++;
            c--;
        }
        
        return true;
    }
}