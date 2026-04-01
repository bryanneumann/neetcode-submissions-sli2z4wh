class Solution {
    public int minimumSpanningTree(
        List<List<Integer>> edges, int n) {
        UnionFind uf = new UnionFind(n);
        Queue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[0] - b[0]);
        for (List<Integer> edge : edges){
            int n1 = edge.get(0);
            int n2 = edge.get(1);
            int w1 = edge.get(2);
            minHeap.offer(new int[]{w1, n1, n2});
        }
        int total = 0;
        while (!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int n1 = cur[1];
            int n2 = cur[2];
            int w2 = cur[0];
            if (uf.union(n1, n2)){
                total += w2;
            }
        }
        if (uf.n == 1){
            return total;
        }
        return -1;
    }

    class UnionFind {
        int n;
        int[] parent;
        int[] rank;

        int getCount(){
            return n;
        }
        public UnionFind(int n){
            this.n = n;
            this.parent= new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
                rank[i]= 1;
            }
        }

        boolean same(int x, int y){
            return find(x) == find(y);
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
            if (rootX != rootY){
                if (rank[rootX] < rank[rootY] ){
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
