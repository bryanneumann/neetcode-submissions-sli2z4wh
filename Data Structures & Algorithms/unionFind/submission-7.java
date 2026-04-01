class UnionFind {
    int n;
    int[] rank;
    int[] parent;
    public UnionFind(int n) {
        this.n = n;
        this.rank = new int[n];
        this.parent = new int[n];
        for (int i = 0; i < n; i++){
            this.rank[i] = 1;
            this.parent[i] = i;
        }
    }

    public int find(int x) {
        if (x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    // Union with path compression
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY){
            if (rank[rootX] < rank[rootY]){
                parent[rootY] = parent[rootX];
                rank[rootX] += rank[rootY];
            } else {
                parent[rootX] = parent[rootY];
                rank[rootY] += rank[rootX];
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
