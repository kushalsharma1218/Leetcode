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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> verticalOrder = new ArrayList<>();
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(root, 0, 0));
        
        while(!queue.isEmpty())
        {
            Point currNode = queue.poll();
            
            if(!map.containsKey(currNode.vLevel)){
                map.put(currNode.vLevel, new TreeMap<>());
            }
            
            if(!map.get(currNode.vLevel).containsKey(currNode.hLevel)){
                map.get(currNode.vLevel).put(currNode.hLevel, new PriorityQueue<>());
            }
            
            map.get(currNode.vLevel).get(currNode.hLevel).add(currNode.node.val);
                
            if(currNode.node.left != null){
                queue.add(new Point(currNode.node.left, currNode.vLevel-1, currNode.hLevel+1));
            }
                
            if(currNode.node.right != null){
                queue.add(new Point(currNode.node.right, currNode.vLevel+1, currNode.hLevel+1));
            }
        }
        
        System.out.println(map);
        
        //for every vertical
        for(TreeMap<Integer, PriorityQueue<Integer>> valuesByLevel: map.values())
        {
            verticalOrder.add(new ArrayList<>());
            int size = verticalOrder.size();
            for(PriorityQueue<Integer> pq: valuesByLevel.values())
            {
                while(!pq.isEmpty()){
                    verticalOrder.get(size-1).add(pq.poll());
                }
            }
        }
        
        return verticalOrder;
    }
}
class Point{
    TreeNode node;
    int vLevel;
    int hLevel;
    
    Point(TreeNode node, int vLevel, int hLevel){
        this.hLevel = hLevel;
        this.vLevel = vLevel;
        this.node = node;
    }
}