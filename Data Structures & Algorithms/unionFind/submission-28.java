class UnionFind {
    int n;
    int parent[];
    public UnionFind(int n) {
        this.n = n;
        parent = new int[n];
        for (int i = 0; i < n; i++){
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
        if (rootX == rootY){
            return false;
        }
        if (rootX > rootY){
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
        }
        n--;
        return true;
    }

    public int getNumComponents() {
        return this.n;
    }
}
