import java.util.*;

class A
{
	public static void main(final String ar[]) {
        final int n = new Scanner(System.in).nextInt();

        System.out.println(check(n));

    }

    public static boolean check(int n) {
        final Set<Integer> s = new HashSet<>();
        s.add(n);
        while (true) {
            final int x = square(n);
			if(x==1)return true;
			if(s.contains(x))return false;
			s.add(x);
			n=x;
		}
	}
	public static int square(int n)
	{
		int sum=0;
		while(n!=0)
		{
			sum=sum+(n%10)*(n%10);
			n=n/10;
		}
		return sum;
	}
}
