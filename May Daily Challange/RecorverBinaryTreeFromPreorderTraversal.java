/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String s) {
        // what we actually need to do is 
        // we need to find level of node and we can do that by find number of cotinue - in string
        // and we need to add this node at that level
        
        // to go on the required level we will use stack that will store all the nodes added
        
        // we know that its a preorder so first node will be root   
        // its a preoder so first will be root and then the terms until first right appers they all belogs to           // left subtree
        Stack<TreeNode> st = new Stack<>();
        
        for(int i = 0;i<s.length();)
        {
            // find level
            int level = 0;
            while(i<s.length() && s.charAt(i) == '-'){
                level++;
                i++;
            }
            
            // convert node data from char tp integer
            
            int num = 0;
            while(i < s.length() && s.charAt(i) != '-')
            {
                num = (num*10 )+ (int)s.charAt(i)-'0';
                i++;
            }
            
            // crete a node
            TreeNode newNode = new TreeNode(num);
            
            // go to the correct level
            // o(h)
            while(st.size() > level)
            {
                st.pop();
            }
            
            if(!st.isEmpty())
            {
                TreeNode prev = st.peek();
                if(prev.left == null)prev.left = newNode;
                else prev.right = newNode;
            }
            
            st.push(newNode);
        }
        
        // removing all children from stack
        while(st.size() > 1)
        {
            st.pop();
        }
        
        return st.pop();
    }
    
}
}