class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        find(n, 0,0,ans,new StringBuffer());
        
        return ans;
    }
    public void find(int max, int open, int close, List<String> ans, StringBuffer sb)
    {
        if(sb.length() == 2 * max)
        {
            ans.add(new String(sb.toString()));
            return;
        }
        
        if(open < max)
        {
            sb.append("(");
            find(max, open+1, close, ans, sb);
            sb.deleteCharAt(sb.length() -1);
        }
        
        if(close < open)
        {
            sb.append(')');
            find(max, open, close+1, ans, sb);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}