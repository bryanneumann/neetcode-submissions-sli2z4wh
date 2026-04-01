class UnionFind {
    int n;
    int[] size;
    int[] parent;
    public UnionFind(int n) {
        this.n = n;
        size = new int[n];
        parent = new int[n];
        for (int i =0; i < n; i++){
            size[i] = i;
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
        if (rootX != rootY){
            if (size[rootX] < size[rootY]){
                parent[rootX] = rootY; 
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
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
