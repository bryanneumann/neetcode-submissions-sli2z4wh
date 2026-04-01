class SegmentTree {
    class Node {
        int L;
        int R;
        Node left;
        Node right;
        int sum;
        public Node(int L, int R, int sum){
            this.L = L;
            this.R = R;
            this.sum = sum;
        }
    }
    Node tree;
    public SegmentTree(int[] nums) {
        tree = build(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
       update(tree, index, val); 
    }

    void update(Node node, int i, int val){
        if (node.L == node.R){
            node.sum = val;
            return;
        }
        int M = node.L + (node.R - node.L) / 2;
        if (i > M){
            update(node.right, i, val);
        } else {
            update(node.left, i, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    Node build(int[] nums, int L, int R){
        if (L == R){
            return new Node(L, R, nums[L]);
        }
        int M = L + (R - L) / 2;
        Node node = new Node(L, R, 0);
        node.left = build(nums, L, M);
        node.right = build(nums, M + 1, R);
        node.sum = node.left.sum + node.right.sum;
         
        return node;
    }

    public int query(int L, int R) {
        return query(tree, L, R);
    }

    int query(Node node, int L, int R){
        if (L <= node.L && node.R <= R){
            return node.sum;
        }
        if (R < node.L || L > node.R){
           return 0; 
        }
        return query(node.left, L, R) + query(node.right, L, R);
    }
}
