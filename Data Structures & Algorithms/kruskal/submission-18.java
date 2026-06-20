class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (List<Integer> edge : edges){
            minHeap.offer(new int[]{edge.get(2), edge.get(0), edge.get(1) });
        }
        Dsu dsu = new Dsu(n);
        int total = 0;
        while (!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int x = cur[1];
            int y = cur[2];
            int w = cur[0];
            if (dsu.union(x, y)){
                total += w;
            }
        }
        if (dsu.n != 1){
            return -1;
        }
        return total;
    }

    class Dsu {
        private int n;
        private int[] parent;
        private int[] rank;
        public Dsu(int n){
            this.n = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++){
                this.rank[i] = 1;
                this.parent[i] = i;
            }
        }
        boolean union(int x, int y){
            int rx = find(x);
            int ry = find(y);
            if (rx == ry){
                return false;
            }
            if (rank[rx] >= rank[ry]){
                parent[rx] = ry;
                rank[ry] += rank[rx];
            } else {
                parent[ry] = rx;
                rank[rx] += rank[ry];
            }
            n--;
            return true;
        }
        int find(int x){
            if (x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
