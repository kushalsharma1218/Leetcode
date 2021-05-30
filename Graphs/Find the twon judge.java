class Solution {
    public int findJudge(int n, int[][] trust) {
        int people[] = new int[n+1];
        int judge[] = new int[n+1];
        
        for(int i = 0;i<trust.length;i++)
        {
            people[trust[i][0]]++;
            judge[trust[i][1]]++;
        }
        
        for(int i = 1;i<n+1;i++)
        {
            if(people[i] == 0 && judge[i] == n-1)return i;
        }
        return -1;
        
        
    }
}