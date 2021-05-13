import java.io.IOException;
import java.util.*;

class Solution {
	public static void main(final String ar[]) throws IOException {
		final java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine().trim());
		final String arr[] = br.readLine().split(" ");
		final int num[] = new int[n];
		for(int i=0;i<n;i++)
		{
			num[i]=Integer.parseInt(arr[i]);
		}
		System.out.println(singleNumber(num));
	}
    public static int singleNumber(final int[] num) {
		final HashMap<Integer, Integer> hash = new HashMap<>();

		for (int i = 0; i < num.length; i++) {
			if (hash.containsKey(num[i])) {
				hash.put(num[i], hash.get(num[i]) + 1);
			} else {
				hash.put(num[i], 1);
			}
		}
		int ans = 0;
		final Iterator it = hash.entrySet().iterator();
		while (it.hasNext()) {
			final Map.Entry element = (Map.Entry) it.next();
			final int val = (int) element.getValue();
				if(val==1){
					ans= (int)element.getKey();
		
			}
        return ans;
}
}