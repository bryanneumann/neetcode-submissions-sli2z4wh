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
            rank[i]= 1;
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
        if (rootX != rootY){
            if (rank[rootX] < rank[rootY]){
                parent[rootY] = parent[rootX];
                rank[rootY] += rank[rootX];
            } else {
                parent[rootX] = parent[rootY];
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
