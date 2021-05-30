class Solution {
    public String toLowerCase(String s) {
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0;i<s.length();i++)
        {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')sb.append(s.charAt(i));
            else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')sb.append((char)(s.charAt(i) + 32));
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}