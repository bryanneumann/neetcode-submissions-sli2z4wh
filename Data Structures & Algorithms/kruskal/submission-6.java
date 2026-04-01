class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        UnionFind uf = new UnionFind(n);
        Queue<int[]> minHeap  = new PriorityQueue<>((a, b)->a[0] - b[0]);
        int total= 0;

        for (List<Integer> edge : edges){
            int n1 = edge.get(0);
            int n2 = edge.get(1);
            int w = edge.get(2);
            minHeap.offer(new int[]{w, n1, n2});
        }
        while (!minHeap.isEmpty()){
            int qlen = minHeap.size();
            for (int i = 0; i < qlen; i++){
                int[] cur = minHeap.poll();
                int w = cur[0];
                int n1 = cur[1];
                int n2 = cur[2];
                if (uf.union(n1, n2)){
                   minHeap.offer(new int[]{w, n1, n2}) ;
                   total+=w; 
                }
            }
        }
        if (uf.n == 1){ // 1 disjoint set
            return total;
        } 
        // Graph is disconnected 
        return -1;
    }

    class UnionFind {
        int n;
        int[] parent;
        int[] rank;
        public UnionFind(int n){
            this.n = n;
            this.rank= new int[n];
            this.parent = new int[n];
            for (int i = 0; i < n; i++){
                this.parent[i] = i;
                this.rank[i] = 1;
           } 
        }
        int find(int x){
            if (x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            // Compress the paths
            if (rootX != rootY){
                if (rank[rootX] < rank[rootY]){
                    parent[rootX] = parent[rootY];
                    rank[rootY] += rank[rootX];
                } else {
                    parent[rootY] = parent[rootX];
                    rank[rootX] += rank[rootY];
                }
                n--;
                return true;
            }
            return false;
        }
    }
}
