import java.util.*;

class A
{
	public static void main(final String ar[]) {
		final int arr[] = { -1, 11, -3, -4, 1, 2, 1, 5, 4 };

		int start = 0;
		int end = 0;
		 int maxsofar = 0;
	    int maxcurr = 1;

		for(int i=0;i<arr.length;i++)
		{
			maxcurr=maxcurr*arr[i];
			if(maxcurr<0)
			{
				start=i+1;
				maxcurr=1;
			}
			if(maxcurr>maxsofar)
			{
				end=i;
				maxsofar=maxcurr;

			}

		}
		for(int i=start;i<=end;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
	}
}