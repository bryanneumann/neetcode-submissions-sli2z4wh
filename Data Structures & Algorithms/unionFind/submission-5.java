class UnionFind {

    int n;
    int[] parent;
    int[] rank;
    public UnionFind(int n) {
        this.n = n;
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++){
            rank[i] = 1;
            parent[i] = i;
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

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
// rank y, rank x
// parent x, parent y
        if (rootX != rootY){
            if (rank[rootX] < rank[rootY]){
                rank[rootY] += rank[rootX];
                parent[rootX] = rootY;
            } else {
                rank[rootX] += rank[rootY];
                parent[rootY] = rootX;
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
