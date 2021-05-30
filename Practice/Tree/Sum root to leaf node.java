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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        find(root, new StringBuilder());
        return sum;
    }
    public void find(TreeNode root, StringBuilder sb ){
        if(root == null)return;
        sb.append(root.val);
        if(root.left == null && root.right == null)
        {
            sum += Integer.parseInt(sb.toString());
            sb.deleteCharAt(sb.length() -1);
            return;
            
        }
        
        find(root.left, sb);
        find(root.right, sb);
        sb.deleteCharAt(sb.length() -1);
        return;
    }
    
}