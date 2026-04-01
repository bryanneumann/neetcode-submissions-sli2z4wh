class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        int totalWeight = 0;
        UnionFind uf = new UnionFind(n);
        Queue<int[]> minHeap = new PriorityQueue<>( 
            (a,b) -> a[0] - b[0]
        );
        for (List<Integer> edge : edges){
            minHeap.offer(new int[]{edge.get(2), edge.get(1), edge.get(0)});
        }
        while (!minHeap.isEmpty()){
           int[] cur = minHeap.poll();
           int w = cur[0];
           int n1 = cur[1];
           int n2 = cur[2];
           if (uf.union(n1, n2)){
             totalWeight += w;
           }
        }
        if (uf.n == 1){ // 1 disjoint set
            // If the graph is connected, return the weight
            return totalWeight;
        }
        // If the graph is disconnected
        return -1;
    }

        class UnionFind {
    int n;
    int[] parent;
    int[] rank;
    public UnionFind(int n) {
        this.n = n;
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x != parent[x]){
            parent[x]= find(parent[x]);
        }
        return parent[x];
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY){
            if (rank[rootX]< rank[rootY]){
                parent[rootX] = parent[rootY];
                rank[rootY] += rank[rootX];
            } else {
                parent[rootY]= parent[rootX];
                rank[rootX] += rank[rootY];
            }
            n--;
            return true;
        }
    return false;
    }   

    public int getNumComponents() {
        return n;
    }
}

}
