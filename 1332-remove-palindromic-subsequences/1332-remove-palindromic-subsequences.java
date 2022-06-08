/*
Observation:
Word has only 2 types of letter a and b
So ans can be at max 2 only

okie.. we can only has 3 ans:- 0,1,2
for 0 we will have empty string
for 1 it should be pallindrome
else 2

*/
class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() ==0)return 0;
        //check plaaindrome
        int i = 0;
        int j = s.length()-1;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return 2;
            }
            i++;
            j--;
        }
        
        return 1;
    }
}