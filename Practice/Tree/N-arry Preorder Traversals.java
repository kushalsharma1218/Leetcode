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
    public List<Integer> preorder(Node root) {
        if(root == null)return new ArrayList<Integer>();
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Node> queue = new Stack<>();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            Node curr = queue.pop();
            al.add(curr.val);
            for(int i = curr.children.size()-1;i>=0;i--)
            {
                queue.push(curr.children.get(i));
            }
        }
                          
         return al;      
    }
}