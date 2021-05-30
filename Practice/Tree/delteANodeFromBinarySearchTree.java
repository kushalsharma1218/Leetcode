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
    public TreeNode deleteNode(TreeNode root, int key) {
        // we need to serach our node
        if(root == null)return null;
        if(root.val >  key)
        {
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key)
        {
            root.right = deleteNode(root.right, key);
        }
        else{
            // we have three case to figure out before deleting
            
            // 1. The nod eot be deleted can be a leaf node...... we can delete it directly
            // 2. The nod eto be deleted can have only one child .... in taht case we will replce it with the present child
            // 3. the node having both childs ... so in this case we have to find the closest node o the curr node and replce both
            
            if(root.left == null)return root.right;
            if(root.right == null)return root.left;
            
            TreeNode closestnode = findClosest(root.right);
            root.val = closestnode.val;
            root.right = deleteNode(root.right, closestnode.val);
        }
        return root;
    }
    public TreeNode findClosest(TreeNode root)
    {
        if(root == null)return root;
        while(root != null && root.left != null)root = root.left;
        return root;
        
    }
}