class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Queue<List<Integer>> minHeap =
            new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
        UnionFind uf = new UnionFind(n);
        for (List<Integer> edge : edges){
            int w = edge.get(2);
            int n1 = edge.get(0);
            int n2 = edge.get(1);
            List<Integer> t = new ArrayList<>();
            t.add(w);
            t.add(n1);
            t.add(n2);
            minHeap.offer(t);
        }
        int total = 0;
        while (!minHeap.isEmpty()){
            List<Integer> cur = minHeap.poll();
            int w1 = cur.get(0);
            int n1 = cur.get(1);
            int n2 = cur.get(2);
            if (uf.union(n1, n2)){
                total += w1;
            }
        }
        if (uf.n == 1){
            return total;
        }
        return -1;
    }

    class UnionFind{
        int n = 0;
        int[] parent;
        int[] rank;
        public UnionFind(int n){
            this.n = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++){
                rank[i] = 1;
                parent[i] = i;
            }
        }

        int find(int x){
            if (x != parent[x]){
               parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y ){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY){
                if (rank[rootX] < rank[rootY]){
                   parent[rootX] = parent[rootY];
                   rank[rootY] += rank[rootX];
                } else {
                    parent[rootY] = parent[rootX];
                    rank[rootX] += parent[rootY];
                }
                n--;
                return true;
            }
            return false;
        }
    }
}
