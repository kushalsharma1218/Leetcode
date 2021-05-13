import java.util.*;
class A
{
	public static void main(String ar[])
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = sc.nextInt();
		System.out.println(removeDuplicates(s,n));
		
	}
	 public static String removeDuplicates(String s, int k) {
        if(s.length() < k)return s;
        boolean canDelete = true;
   
        while(s.length() >=  k && canDelete)
        {
            int count = 1;
            canDelete = false;
            for(int i = 1;i<s.length();i++)
            {
                System.out.println(s);
                if(s.charAt(i) == s.charAt(i-1))
                {
                    count++;
                    if(count == k)
                    {
                        canDelete = true;
                        s = s.substring(0,i-count+1) + s.substring(i+1);
                        count =1;
                    }
                }
                else
                {
                    count =1;
                }
            }
        }
        return s;
    }
}