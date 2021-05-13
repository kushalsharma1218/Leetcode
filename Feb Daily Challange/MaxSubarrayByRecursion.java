import java.util.*;

class A
{
	
	public static void main(final String ar[]) {
		final int arr[] = {-2,1,-3,4,-1,2,1,-5,4};

		int start = 0;
		int end = 0;
		 int maxsofar = 0;
	    int maxcurr = 0;
System.out.println(maxsubArray(arr,maxcurr,maxsofar,0));

	}
	public static int maxsubArray (int arr[],int maxcurr,int maxsofar,int i)
	{
		if(i>=arr.length)return maxsofar;

		maxcurr=maxcurr+arr[i];
		if(maxcurr<0)maxcurr=0;
		if(maxcurr>maxsofar)maxsofar=maxcurr;

		return maxsubArray(arr,maxcurr,maxsofar,++i);
		
	}

}