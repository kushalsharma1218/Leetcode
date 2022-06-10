/*
Talking about brute solution: generate all possible substrings and check for duolicate characters
isValidSubstrin(); : O(N)

Tc: O(N2)

 2nd approach: Map charcters to and array, so basically I will be marking character in arr[26]
 So when I find a duplicate character then I can just traverse and remove based on two appraoch
 Tc: O(2n)
 
 2rd appraoch: Tc:O(N)


*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int arr[] = new int[127];
        Arrays.fill(arr, -1);
        int start = 0;
        
        
        int maxLen = 0;
        for(int end = 0;end<s.length();end++){
            //mark presence
            if(arr[s.charAt(end)] != -1)
            {
                start = Math.max(start, arr[s.charAt(end)] + 1);
                arr[s.charAt(end)] = -1;
            }
            
            arr[s.charAt(end)] = end;
            
            maxLen = Math.max(maxLen, end - start+1);
            
        }
        return maxLen;
    }
}