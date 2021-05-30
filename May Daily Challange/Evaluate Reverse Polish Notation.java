class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String i : tokens)
        {
            if(isOperator(i))
            {
                int a = stack.pop();
                int b = stack.pop();
                
                int c = calculate(a,b,i);
                
                stack.push(c);
            }
            else
            {
                stack.push(Integer.parseInt(i));
            }
        }
        
        return stack.pop();
    }
    public boolean isOperator(String s)
    {
        return (s.equals("/") || s.equals("+") || s.equals("-") || s.equals("*"));
    }
    public int calculate(int a , int b, String op)
    {
        if(op.equals("/"))return b/a;
        if(op.equals("+"))return b+a;
        if(op.equals("-"))return b-a;
        if(op.equals("*"))return b*a;
    
        return -1;
    }
}