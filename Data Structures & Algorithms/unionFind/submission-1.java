class UnionFind {
    int[] parent;
    int[] size;
    int components;

    public UnionFind(int n) {
        components = n;
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < components; i++){
            parent[i] = i;
            size[i] = 1;
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
        int rootY =find(y);
        if (rootX != rootY){
            if (size[rootX] < size[rootY]){
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            components--;
            return true;
        }
        return false;
    }

    public int getNumComponents() {
        return components;
    }
}
