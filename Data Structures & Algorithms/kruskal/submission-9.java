class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        UnionFind uf = new UnionFind(n);
        Queue<int[]> minHeap = new PriorityQueue<>( (a, b) -> a[0] - b[0]);
        int totalWeight = 0;
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
                int n1= cur[1];
                int n2= cur[2];
                if (uf.union(n1, n2)){
                    totalWeight += w;
                    minHeap.offer(new int[]{totalWeight, n1, n2});
                }
            }
        }
        if (uf.getDisjointSets() == 1){
            return totalWeight;
        }
        return -1;
    }

    class UnionFind{
        int n ;
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

        int getDisjointSets(){
            return n;
        }
        boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
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

        int find(int x){
            if (x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
