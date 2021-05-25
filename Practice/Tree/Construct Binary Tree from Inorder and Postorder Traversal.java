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
    Map<Integer, Integer> map;
    int postIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        postIndex = postorder.length -1;
        for(int i = 0;i<postorder.length;i++)
        {
            map.put(inorder[i] , i);
        }
        
        return buildTree(inorder, postorder, 0, inorder.length -1);
    }
    public TreeNode buildTree(int in[], int post[], int start, int end)
    {
        if(start <= end)
        {
            TreeNode node = new TreeNode(post[postIndex]);
            int index = map.get(post[postIndex--]);
            node.right = buildTree(in, post, index+1, end);
            node.left = buildTree(in, post, start, index -1);
            return node;
        }
        return null;
    }
}