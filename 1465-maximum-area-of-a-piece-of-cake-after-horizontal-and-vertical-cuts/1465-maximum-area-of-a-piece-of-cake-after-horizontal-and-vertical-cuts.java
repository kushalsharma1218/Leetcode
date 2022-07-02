class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = (int)1e9 + 7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxHorizontalDis = 0;
        long maxVerticalDis = 0;
        int n = horizontalCuts.length;
        int m = verticalCuts.length;
        int prev = 0;

        for(int i = 0;i<=n;i++)
        {
            if(i < n){
                maxHorizontalDis = Math.max(horizontalCuts[i] - prev, maxHorizontalDis);
                prev = horizontalCuts[i];
            }
            else{
                maxHorizontalDis = Math.max(h - prev, maxHorizontalDis);
            }
        }
        
        prev = 0;
        for(int i = 0;i<=m;i++)
        {
            if(i < m){
                maxVerticalDis = Math.max(verticalCuts[i] - prev, maxVerticalDis);
                prev = verticalCuts[i];
            }
            else{
                maxVerticalDis = Math.max(w - prev, maxVerticalDis);
            }
        }
        
        return  (int)(maxVerticalDis%mod * maxHorizontalDis%mod)%mod;
    }
}