class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        if (matchsticks == null || matchsticks.length == 0) {
            return false;
        }

        // Find the perimeter of the square (if at all possible)
        int L = matchsticks.length;
        int perimeter = 0;
        for(int i = 0; i < L; i++) {
            perimeter += matchsticks[i];
        }

        int possibleSquareSide =  perimeter / 4;
        if (possibleSquareSide * 4 != perimeter) {
            return false;
        }
        //side will be representing sides of square
       
        int side[] = new int[] {possibleSquareSide,possibleSquareSide,possibleSquareSide,possibleSquareSide};
        return find(0, matchsticks, side);
        
    }
    public boolean find(int index, int m[], int side[])
    {
        //base case
        if(index == m.length)
        {
            return side[0] == side[1] && side[2] == side[3] && side[0] == side[2];
        }
        
        
        // what we can do is we can include a mtch stick in one of the four side
        // So which side should we inlcude
        // try them all
        
        for(int i = 0;i<4;i++)
        {
            if(m[index] <= side[i])
            {
                side[i] -= m[index];
                if(find(index+1, m, side))return true;
                side[i] += m[index];
            }
        }
        
        return false;
    }
}