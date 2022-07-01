class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        
        int unitCount = 0;
        
        for(int i = 0;i<boxTypes.length;i++)
        {
            int boxCount = Math.min(truckSize, boxTypes[i][0]);
            unitCount += boxCount * boxTypes[i][1];
            truckSize -= boxCount;
            if (truckSize == 0)
                break;
        }
        
        return unitCount;
    }
}