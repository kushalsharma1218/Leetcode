class Solution {
    public int maxPathSum(TreeNode root) {
        int max[] = new int[]{Integer.MIN_VALUE};
        find(root, max);
        return max[0];
    }
    public int find(TreeNode root, int max[])
    {
        if(root == null)return 0;
        
        int leftSum = find(root.left, max);
        int rightSum = find(root.right, max);
        
        int currMax = Math.max(leftSum + rightSum + root.val, Math.max(leftSum, rightSum)+root.val);
        currMax = Math.max(currMax, root.val);
        
        max[0] = Math.max(max[0], currMax);
        
        
        return Math.max(Math.max(leftSum, rightSum) + root.val, root.val);
    }
}