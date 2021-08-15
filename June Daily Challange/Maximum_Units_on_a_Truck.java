class Solution {
    public int maximumUnits(int[][] boxes, int truckSize) {
        Arrays.sort(boxes, (a, b) -> b[1] - a[1]);
        int n = boxes.length;
        int maxUnits = 0;
        for(int i = 0;i<n;i++)
        {
            if(truckSize >= boxes[i][0])
            {
                truckSize -= boxes[i][0];
                maxUnits += (boxes[i][0] * boxes[i][1]);
            }
            else
            {
                maxUnits += (truckSize * boxes[i][1]);
                break;
            }
        }
        
        return maxUnits;
    }
}