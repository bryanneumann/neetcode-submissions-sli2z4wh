class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (List<Integer> edge : edges) {
            int s = edge.get(0);
            int d = edge.get(1);
            int w = edge.get(2);
            minHeap.offer(new int[] {w, s, d});
        }
        DSU uf = new DSU(n);
        int total = 0;
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (uf.union(cur[1], cur[2])) {
                total += cur[0];
            }
        }
        // If not connected
        if (uf.components != 1) {
            return -1;
        }
        return total;
    }

    public class DSU {
        int components;
        int[] parent;
        int[] rank;
        public DSU(int n) {
            this.components = n;
            this.parent = new int[n];
            this.rank = new int[n];
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
            components--;
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
