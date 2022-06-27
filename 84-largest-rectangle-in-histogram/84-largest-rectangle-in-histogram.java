class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int prev[] = new int[n];
        int next[] = new int[n];
        
        prev[0] = -1;
        Stack<Integer> st1 = new Stack<>();
         Stack<Integer> st2 = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!st1.isEmpty() && heights[st1.peek()] >= heights[i])
            {
                st1.pop();
            }
            
            if(st1.isEmpty()){
                prev[i] = -1;
            }
            else{
                prev[i] = st1.peek();
            }
            
            st1.push(i);
            
            while(!st2.isEmpty() && heights[st2.peek()] >= heights[n - i -1])
            {
                st2.pop();
            }
            
            if(st2.isEmpty()){
                next[n - i - 1] = n;
            }
            else{
                next[n - i - 1] = st2.peek();
            }
            
            st2.push(n- i -1);
        }
        
        
        int maxArea = 0;
        for(int i= 0;i<n;i++){
            maxArea = Math.max(maxArea, (next[i] - prev[i] - 1) * heights[i]);
        }
        
        return maxArea;
    }
}