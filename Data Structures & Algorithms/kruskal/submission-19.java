class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        int mst = 0;
        UnionFind uf = new UnionFind(n);
        Queue<int[]> minHeap = new PriorityQueue<>( (a,b) -> a[0] - b[0]);
        for (List<Integer> edge : edges){
            minHeap.offer(new int[]{edge.get(2), edge.get(0), edge.get(1)});
        }
        while (!minHeap.isEmpty()){
            int[] edge = minHeap.poll();
            if (uf.union(edge[1], edge[2])) {
                mst += edge[0];
            }
        }
        if (uf.numberOfComponents() != 1){
            return -1;
        }
        return mst;
    }

    // Union by rank with path compression
    class UnionFind {
        int n;
        int[] parent;
        int[] rank;
        UnionFind(int n) {
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int numberOfComponents(){
            return n;
        }

        int find(int x) {
            if (x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
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
    }
}
