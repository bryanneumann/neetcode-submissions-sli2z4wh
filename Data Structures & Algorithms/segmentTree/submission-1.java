class SegmentTree {
    class Node {
        int L;
        int R;
        Node left = null;
        Node right = null;
        int sum;
    }

    Node root;
    private Node build(int[] nums, int L, int R){
        Node node = new Node();
        node.L = L;
        node.R = R;
        if (L == R){
            node.sum = nums[L];
            return node;
        }
        int M = L + (R - L) / 2;
        node.left = build(nums, L, M);
        node.right = build(nums, M+1, R);
        node.sum = node.left.sum + node.right.sum;
        
        return node;
    }

    public SegmentTree(int[] nums) {
        this.root = build(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    public void update(Node node, int index, int val) {
        if (node == null){
            return;
        }
        if (node.L == node.R){
            node.sum = val;
            return;
        }
        int M = node.L + (node.R - node.L) / 2;
        if (index > M ){
            update(node.right, index, val);
        } else {
            update(node.left, index, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    public int query(Node node, int L, int R) {
        if (L <= node.L && node.R <= R){
            return node.sum;
        }
        if (R < node.L || L > node.R){
            return 0;
        }
        return query(node.left, L, R) + query(node.right, L, R);
    }

    public int query(int L, int R) {
        return query(root, L, R);
    }
}
