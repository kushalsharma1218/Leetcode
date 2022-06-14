/*
class Solution {
    public int minDistance(String word1, String word2) {
        return minDeletions(word1, word2, 0, 0);
    }
    public int minDeletions(String word1, String word2, int ind1, int ind2){
        if(ind1 >= word1.length() && ind2 >= word2.length())return 0;
        if(ind1 >= word1.length())return word2.length() - ind2;
        if(ind2 >= word2.length())return word1.length() - ind1;
        
        if(word1.charAt(ind1) == word2.charAt(ind2))return minDeletions(word1,word2,ind1+1,ind2+1);
        
        return Math.min(minDeletions(word1,word2,ind1+1,ind2), minDeletions(word1,word2,ind1+1,ind2)) + 1;
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int i = 0;i<word1.length();i++){
            Arrays.fill(dp[i], -1);
        }
        return minDeletions(word1, word2, 0, 0, dp);
    }
    public int minDeletions(String word1, String word2, int ind1, int ind2, int dp[][]){
        if(ind1 >= word1.length() && ind2 >= word2.length())return 0;
        if(ind1 >= word1.length())return word2.length() - ind2;
        if(ind2 >= word2.length())return word1.length() - ind1;
        
        if(dp[ind1][ind2] != -1)return dp[ind1][ind2];
        
        if(word1.charAt(ind1) == word2.charAt(ind2))return dp[ind1][ind2] = minDeletions(word1,word2,ind1+1,ind2+1, dp);
        
        return dp[ind1][ind2] = Math.min(minDeletions(word1,word2,ind1+1,ind2, dp), minDeletions(word1,word2,ind1,ind2+1,dp)) + 1;
    }
}

*/

class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        
        
        for(int i = 0;i<=word1.length();i++){
            for(int j = 0;j<=word2.length();j++)
            {
                if (i == 0 || j == 0)
                    dp[i][j] = i + j;
                else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + 1;
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
        
    }
    public int minDeletions(String word1, String word2, int ind1, int ind2, int dp[][]){
        if(ind1 >= word1.length() && ind2 >= word2.length())return 0;
        if(ind1 >= word1.length())return word2.length() - ind2;
        if(ind2 >= word2.length())return word1.length() - ind1;
        
        if(dp[ind1][ind2] != -1)return dp[ind1][ind2];
        
        if(word1.charAt(ind1) == word2.charAt(ind2))return dp[ind1][ind2] = minDeletions(word1,word2,ind1+1,ind2+1, dp);
        
        return dp[ind1][ind2] = Math.min(minDeletions(word1,word2,ind1+1,ind2, dp), minDeletions(word1,word2,ind1,ind2+1,dp)) + 1;
    }
}