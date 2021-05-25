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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return check(root.left, root.val, targetSum) || check(root.right, root.val, targetSum);
    }
    public boolean check(TreeNode root, int curr, int target)
    {
        if(curr == target) return true;
        if(root == null)return false;
        
       return check(root.left, curr + root.val, target) || check(root.right, curr + root.val, target);
    }
}