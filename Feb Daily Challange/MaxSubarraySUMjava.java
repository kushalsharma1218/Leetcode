import java.util.*;

class A
{
	public static void main(final String ar[]) {
		final int arr[] = {-2,-1};

	
		 int maxsofar = arr[0];
	    int maxcurr = arr[0];

		for(int i=0;i<arr.length;i++)
		{
			
            maxcurr=Math.max(a[i],maxcurr+arr[i]);
            maxsofar=Math.max(maxsofar,maxcurr);

		}
		System.out.println(maxsofar);
		
	}
}