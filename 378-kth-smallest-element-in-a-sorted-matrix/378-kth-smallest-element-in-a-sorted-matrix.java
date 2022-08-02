class Cell implements Comparator<Cell>{
    int row;
    int col;
    int value;
    
    Cell(int r, int c, int val){
        this.row = r;
        this.col = c;
        this.value  = val;
    }
    Cell()
    {
        
    }
    
    public int compare(Cell c1, Cell c2)
    {
        return c1.value - c2.value;
    }
    
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>(k, new Cell());
        
        for(int r = 0;r<Math.min(n, k);r++)
        {
            pq.add(new Cell(r, 0, matrix[r][0]));
        }
        
        Cell cell = pq.peek();
        
        while(k-- > 0)
        {
            cell = pq.poll();
            int r = cell.row;
            int c = cell.col;
            
            if(c + 1 < m)
            {
                pq.add(new Cell(r, c+1, matrix[r][c+1]));
            }
        }
        
        return cell.value;
    }
}