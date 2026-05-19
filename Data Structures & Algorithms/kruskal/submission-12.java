class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        // Store the src, dst, weight values from edges in a min heap using weight
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (List<Integer> edge : edges) {
            minHeap.offer(new int[] {edge.get(2), edge.get(0), edge.get(1)});
        }

        UnionFind uf = new UnionFind(n);
        int totalWeight = 0;
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int w1 = cur[0];
            int n1 = cur[1];
            int n2 = cur[2];
            if (uf.union(n1, n2)) {
                totalWeight += w1;
            }
        }
        // If the graph is disconnected, weight will be -1
        if (uf.components != 1) {
            totalWeight = -1;
        }
        return totalWeight;
    }

    public class UnionFind {
        int components;
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            components = n;
            parent = new int[n];
            rank = new int[n];
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
                // Path compression
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }
    }
}
