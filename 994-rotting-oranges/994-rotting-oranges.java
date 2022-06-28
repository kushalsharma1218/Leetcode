class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean haveRottenOranges = false;
        int freshOranges = 0;
        
        Queue<Pair> queue = new LinkedList<>();
        
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                if(grid[row][col] == 2){
                    //add to queue
                    haveRottenOranges = true;
                    queue.add(new Pair(row, col));
                }
                else if(grid[row][col] == 1){
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges == 0)return 0;
        if(!haveRottenOranges) return -1;
        
        int dx[] = new int[]{0,0,-1,1};
        int dy[] = new int[]{1,-1,0,0};
        
        int steps = 0;
        boolean vis[][] = new boolean[rows][cols];
        
        while(!queue.isEmpty() && freshOranges != 0)
        {
            steps++;
            int size = queue.size();
            for(int j = 0;j<size;j++)
            {
                Pair p = queue.poll();
            
                for(int i = 0;i<4;i++)
                {
                    int newx = p.x + dx[i];
                    int newy = p.y + dy[i];

                    if(newx < 0 || newy < 0 || newx >= rows || newy >= cols || grid[newx][newy] != 1 || vis[newx][newy] == true)continue;
                    freshOranges--;
                    vis[newx][newy] = true;
                    queue.add(new Pair(newx, newy));
                }
            }
        }

        if(freshOranges != 0)return -1;
        return steps;
    }
}
class Pair{
    int x;
    int y;
    
    Pair(int x, int y){
        this.x = x ;
        this.y = y;
    }
}