class SegmentTree {
    public static class Segment{
        int L;
        int R;
        Segment left;
        Segment right;
        int sum ;

        public Segment(int sum, int L, int R){
            this.L = L;
            this.R = R;
            this.sum = sum;
            this.left = null;
            this.right = null; 
        }
    }
    Segment root;
    public SegmentTree(int[] nums) {
        this.root = build(nums, 0, nums.length - 1);
    }
   
    public static Segment build(int[] nums, int L, int R){
        if (L == R){
            return new Segment(nums[L], L, R);
        }
        int M = L + (R - L) / 2;
        Segment root = new Segment(0, L, R);
        root.left = build(nums, L, M);
        root.right = build(nums, M + 1, R);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    void update(Segment segment, int index, int val){
        if (segment.L == segment.R){
            segment.sum = val;
            return;
        }
        int M = segment.L + (segment.R - segment.L) / 2;
        if (index > M){
            update(segment.right, index, val);
        } else {
            update(segment.left, index, val);
        }
        segment.sum = segment.left.sum + segment.right.sum;
    }

    public int query(int L, int R) {
        return query(root, L, R);
    }

    public int query(Segment segment, int L, int R){
        if (L <= segment.L && segment.R <= R){
            return segment.sum;
        }
        if (R < segment.L || L > segment.R){
            return 0;
        }
        return query(segment.left, L, R) +
         query(segment.right, L, R);
    }
}
