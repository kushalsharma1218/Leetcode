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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        //bfs solution
        
        //root -> 0
        // insert (2*i + 1/2) -1 for removing overflow error
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        
        int maxWidth = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().getValue();
            int firstNode = -1;
            int lastNode = -1;
            
            for(int i = 0;i<size;i++)
            {
                Pair<TreeNode, Integer> pairNode = queue.poll();
                int number = pairNode.getValue() - min;
                if(i == 0)firstNode = number;
                if(i == size-1)lastNode = number;
                TreeNode node = pairNode.getKey(); 
                if(node.left != null){
                    queue.add(new Pair(node.left, (2*number +1)));
                }
                if(node.right != null){
                    queue.add(new Pair(node.right, (2*number +2)));
                }
            }
            
            maxWidth = Math.max(maxWidth, lastNode - firstNode +1);
        }
        
        return maxWidth;
    }
}