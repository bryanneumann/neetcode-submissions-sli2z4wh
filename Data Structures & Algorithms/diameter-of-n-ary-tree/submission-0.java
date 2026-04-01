/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;JJJUFSDF
        children = _children;
    }
};
*/

class Solution {
   
    int maxHeight = 0;
    public int diameter(Node root) {
        dfsHeight(root);
        return maxHeight;        
    }

    int dfsHeight(Node root){
        if (root == null || root.children.isEmpty()){
            return 0;
        }
        int maxHeightA = 0;
        int maxHeightB = 0;
        for (Node child : root.children){
            int h = dfsHeight(child) + 1;
            if (h > maxHeightA){
                maxHeightB = maxHeightA;
                maxHeightA = h;
            } else if (h > maxHeightB){
                maxHeightB = h;
            }
        }
        // Distance between two farthest apart nodes
        int dis = maxHeightA + maxHeightB;
        maxHeight = Math.max(maxHeight, dis);
        return maxHeightA;
    }
}
