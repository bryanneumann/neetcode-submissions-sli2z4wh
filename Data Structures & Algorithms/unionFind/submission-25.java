class UnionFind {
    int[] rank;
    int[] parent;
    int n;
    public UnionFind(int n) {
        this.n = n;
        this.rank = new int[n];
        this.parent= new int[n];
        for (int i = 0; i < n; i++){
            this.rank[i] = 1;
            this.parent[i] = i;
        } 
    }

    public int find(int x) {
        if (x != parent[x]){
            // Compress paths
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY){
            return false;
        }
        if (rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
        } else {
            parent[rootY] = rootX;
            rank[rootY] = rootY;
        }
        n--;
        return true;
    }

    public int getNumComponents() {
        return n;
    }
}
