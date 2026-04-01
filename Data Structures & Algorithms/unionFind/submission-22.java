class UnionFind {
    Map<Integer, Integer> rank;
    Map<Integer, Integer> parent;
    int n ;
    public UnionFind(int n) {
        this.n = n;
        this.rank = new HashMap<>();
        this.parent = new HashMap<>();
        for (int i = 0; i < n; i++){
            rank.put(i, 1);
            parent.put(i, i);
        }
    }

    public int find(int x) {
        if (x != parent.get(x)){
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
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
        if (rank.get(rootX) < rank.get(rootY)){
           parent.put(rootX, rootY);
           rank.put(rootY, rank.get(rootY) + rank.get(rootX));
        } else {
            parent.put(rootY, rootX);
            rank.put(rootX, rank.get(rootY) + rank.get(rootX));
        }
        this.n--;
        return true;
    }

    public int getNumComponents() {
        return n;
    }
}
