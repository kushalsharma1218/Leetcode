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
    TreeNode head = null;
    TreeNode prev = null;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null)return null;
        
        // first we traversed upto the left leaf node
        // and taken two nodes as null as head and prev 
        // prev for updating out right tree and head for holding teh root of new tree
        // we using prev for holding the last node we added in our new tree
        increasingBST(root.left);
        if(root != null)
        {
            
            TreeNode curr = new TreeNode(root.val);
            if(head == null)head = curr;
            else
            {
                prev.right = curr;
            }
            
            prev = curr;
        }
        increasingBST(root.right);
        return head;
    }
}