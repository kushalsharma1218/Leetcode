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
    public void flatten(TreeNode root) {
        if(root == null)return;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        prev = null;
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode curr = st.pop();
            if(curr.right != null)
            {
                st.push(curr.right);
            }
            if(curr.left != null)
            {
                st.push(curr.left);
            }
            if(prev == null)
            {
                prev = curr;
                prev.left = null;
            }
            else
            {
                prev.right  = curr;
                prev.left = null;
                prev = curr;
            }
        }
        
    }
}