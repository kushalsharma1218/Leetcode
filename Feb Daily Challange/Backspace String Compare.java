import java.util.*;
class A {

	public static void main(String ar[])
	{
	
	System.out.println(backspaceCompare("a#c","b"));
		
	}
    public static boolean  backspaceCompare(String S, String T) {
   
        Stack<Character> st=new Stack<Character>();
        
        String s1="";
        int i=0;
        while(i<S.length())
        {
            if(S.charAt(i)!='#')
            {
                st.push(S.charAt(i));
            }
            else
            {
                if(!st.isEmpty())
                st.pop();
            }
            i++;
        }
        i=0;
        while(!st.isEmpty())
        {
            s1=s1+st.pop();
        }
         System.out.println(" s1 ="+s1);
        String s2="";
        
        int j=0;
        while(j<T.length())
        {
            if(T.charAt(j)!='#')
            {
                st.push(T.charAt(j));
            }
            else
            {
                if(!st.isEmpty())
                st.pop();
            }
            j++;
        }
        j=0;
        while(!st.isEmpty())
        {
            s2=s2+st.pop();
        }
        
         System.out.println(" s2 ="+s2);
        return s1.equals(s2);       
    }
}