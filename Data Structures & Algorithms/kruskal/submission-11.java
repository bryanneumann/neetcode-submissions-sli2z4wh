class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Queue<int[]> minHeap = new PriorityQueue<>( (a, b) -> a[0] - b[0]);
        for (List<Integer> edge : edges){
            int s = edge.get(0);
            int d = edge.get(1);
            int w = edge.get(2);
            minHeap.add(new int[]{w, s, d});
        }

        UnionFind uf = new UnionFind(n);
        int total = 0;
        while (!minHeap.isEmpty()){
             int[] cur = minHeap.poll();
             int w1 = cur[0];
             int n1 = cur[1];
             int n2 = cur[2];
             if (uf.union(n1, n2)){
                total += w1;
             } 
        }
        // Return -1 if the graph is disconnected
        if (uf.n != 1){
            total = -1;
        }
        return total;
    }

    public class UnionFind{
        int[] parent;
        int[] rank;
        int n;
        public UnionFind(int n){
            this.n = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
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
            this.n--;
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
