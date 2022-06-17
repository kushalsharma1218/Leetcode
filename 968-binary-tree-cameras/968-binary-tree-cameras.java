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
    int ans = 0;
    public int minCameraCover(TreeNode root) {
        int num = dfs(root) == -1?1:0;
        return ans+num;
    }
    public int dfs(TreeNode root)
    {
        if(root == null)
        {
            return 1;
        }
        
        int l = dfs(root.left);
        int r = dfs(root.right);
        
        if(l  == -1 || r == -1)
        {
            ans++;
            return 0;
        }
        else if(l ==1 && r== 1)
        {
            return -1;
        }
        else if(l ==0 || r == 0)return 1;
        return -1;
    }
}