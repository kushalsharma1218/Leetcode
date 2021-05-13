class Solution {
    public int getMaximumConsecutive(int[] coins) {
        int count = 1;
        Arrays.sort(coins);
        int n = coins.length;
        for(int i =0;i<n;i++)
        {
            if(count>= coins[i])count+= coins[i];
            else break;
        }
        return count;
        
        
    }
}