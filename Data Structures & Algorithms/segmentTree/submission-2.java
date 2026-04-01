class Node {
    int sum;
    Node left;
    Node right;
    int L;
    int R;

    public Node(int total, int L, int R) {
        this.sum = total;
        this.left = left;
        this.right = right;
        this.L = L;
        this.R = R;

    }
}

class SegmentTree {

    Node root;

    public SegmentTree(int[] nums) {
        this.root = build(nums, 0, nums.length - 1);
    }

    private Node build(int[] nums, int L, int R) {
        if (L == R) {
            return new Node(nums[L], L, R);
        }

        int M = (L + R) / 2;
        Node r = new Node(0, L, R);
        r.left = build(nums, L, M);
        r.right = build(nums, M + 1, R);
        r.sum = r.left.sum + r.right.sum;
        return r;
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    private void update(Node node, int index, int val) {
        if (node.L == node.R) {
            node.sum = val;
            return;
        }

        int M = (node.L + node.R) / 2;
        if (index > M) {
            update(node.right, index, val);
        } else {
            update(node.left, index, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    public int query(int L, int R) {
        return rangeQuery(root, L, R);
    }

    private int rangeQuery(Node node, int L, int R) {
        if (L <= node.L && node.R <= R) {
            return node.sum;
        }
        if (R < node.L || L > node.R) {
            return 0;
        }
        return rangeQuery(node.left, L, R) + rangeQuery(node.right, L, R);
    }
}
