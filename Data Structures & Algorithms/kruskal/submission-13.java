class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        PriorityQueue<int[]> mh = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (List<Integer> edge : edges) {
            mh.offer(new int[] {edge.get(2), edge.get(0), edge.get(1)});
        }
        UnionFind uf = new UnionFind(n);
        int total = 0;
        while (!mh.isEmpty()) {
            int[] cur = mh.poll();
            if (uf.union(cur[1], cur[2])) {
                total += cur[0];
            }
        }

        if (uf.n != 1) {
            total = -1;
        }
        return total;
    }

    public class UnionFind {
        int n;
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            this.n = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        boolean union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx == ry) {
                return false;
            }
            if (rank[rx] >= rank[ry]) {
                parent[rx] = ry;
                rank[ry] += rank[rx];
            } else {
                parent[ry] = rx;
                rank[rx] += rank[ry];
            }
            n--;
            return true;
        }
        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
