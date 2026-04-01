class UnionFind {
    int n;
    int[] parent;
    int[] size;
    public UnionFind(int n) {
        this.n = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++){
            size[i] = i;
            parent[i] = i;
        }
    }

    public int find(int x) {
        // Find the root of x 
        if (x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    public boolean union(int x, int y) {
        // Connect x and y
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
            n--; // Reduce num components
            return true;
        }
        return false;
    }

    public int getNumComponents() {
        return n;
    }
}
