class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)return 0;
        
        findPathSum(root, targetSum , 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        
        return count;
    }
    public void findPathSum(TreeNode root, int tSum, int cSum){
        if(root == null)return;
        
        cSum += root.val;
        
        if(cSum == tSum)count++;
        
        findPathSum(root.left, tSum ,cSum);
        findPathSum(root.right, tSum, cSum);
        return;
        
    }
}


class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // whaen we find a gain of k in our subarray
        findPathSum(root, targetSum ,map, 0);
       
        return count;
    }
    public void findPathSum(TreeNode root, int tSum, Map<Integer, Integer> map,  int cSum){
        if(root == null)return;
        
        cSum += root.val;
        if(map.containsKey(cSum - tSum))
        {
            count += map.get(cSum - tSum);
        }
        map.put(cSum , map.getOrDefault(cSum, 0)+1);
        
        findPathSum(root.left, tSum ,map, cSum);
        findPathSum(root.right, tSum, map, cSum);

        map.put(cSum, map.get(cSum) -1);
    }
}