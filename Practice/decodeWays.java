import java.util.*;
class A
{
	public static void main(String ar[])
	{
		Scanner sc= new Scanner(System.in);
		String s = sc.next();
		int i = 0;
		while(i < s.length() && s.charAt(i) == '0')
		{
			i++;
		}
		if(i == s.length())System.out.println("0");
		else
		{ 
			s = s.substring(i,s.length());
			int dp[] = new int[s.length()];
			Arrays.fill(dp,-1);
			System.out.println(getMin(s,0,dp));
		}
	}
	
	    public static int getMin(String s, int i,int dp[])
	{
		//base case
		if(i>s.length())return 0;
		if(i == s.length())return 1;
		if(s.charAt(i) == '0')return 0;
		if(dp[i] != -1)return dp[i];
		int left = 0;
		int  right = 0;
		
		left = getMin(s,i+1,dp);
		if(i+1 < s.length() && (s.charAt(i) < '2' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')))
			right = getMin(s,i+2,dp);
		return dp[i] = left + right;
	}
	
}