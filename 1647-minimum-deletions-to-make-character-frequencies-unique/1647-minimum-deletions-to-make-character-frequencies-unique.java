class Solution {
    public int minDeletions(String s) {
        int deletions = 0;
        int frequency[] = new int[26];
        for(int i = 0;i<s.length();i++){
            frequency[s.charAt(i) - 'a']++;
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<26;i++){
            while(frequency[i] > 0 && set.contains(frequency[i])){
                frequency[i]--;
                deletions++;
            }
            
            set.add(frequency[i]);
        }
        return deletions;
    }
}