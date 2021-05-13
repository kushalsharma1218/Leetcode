class Solution {
    public int lastStoneWeight(int[] stones) {
        
        if(stones.length==1)return stones[0];
        int index1=stones.length-1;
		int index2=stones.length-2;
        Arrays.sort(stones);
        int max1=stones[stones.length-1];
        int max2=stones[stones.length-2];
        if(max1==max2)
        {
            if(stones.length==2)return 0;
            
            int arr[]=new int[stones.length-2];
            for(int i=0;i<stones.length-2;i++)
            {
                arr[i]=stones[i];
            }
            return lastStoneWeight(arr);
        }
        else
        {
            max1=max1-max2;
            stones[stones.length-1]=max1;
            int arr[]=new int[stones.length-1];
            for(int i=0,j=0;i<stones.length;i++)
            {
                if(i!=index2 && j<stones.length-1)
                {
                  arr[j++]=stones[i];
				
                }
            }
			
			return lastStoneWeight(arr);
        }
        
    }
}