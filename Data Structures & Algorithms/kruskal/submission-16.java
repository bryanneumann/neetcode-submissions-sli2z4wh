class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (List<Integer> edge : edges) {
            minHeap.offer(new int[] {edge.get(0), edge.get(1), edge.get(2)});
        }
        int total = 0;
        DSU uf = new DSU(n);
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (uf.union(cur[0], cur[1])) {
                total += cur[2];
            }
        }
        // If the set is disjoint set total to -1
        if (uf.n != 1){
           total = -1; 
        }
        return total;
    }

    class DSU {
        int[] parent;
        int[] weight;
        int n;
        DSU(int n) {
            this.n = n;
            parent = new int[n];
            weight = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        boolean union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx == ry) {
                return false;
            }
            if (weight[rx] >= weight[ry]) {
                parent[rx] = ry;
                weight[ry] += weight[rx];
            } else {
                parent[ry] = rx;
                weight[rx] += weight[ry];
            }
            this.n--;
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
