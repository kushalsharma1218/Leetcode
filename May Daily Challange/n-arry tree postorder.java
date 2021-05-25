/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        
        return al;
    }
  
    // recursivbe way
    public void postOrder(Node root, ArrayList<Integer> al)
    {
        if(root == null)return;
        if(root.children == null)
        {
            al.add(root.val);
            return;
        }
        List<Node> rootList= root.children; // 3 2 4
        for(int i = 0;i<rootList.size();i++)
        {
            postOrder(rootList.get(i), al);
        }
        al.add(root.val);
        return;
        
    }
}