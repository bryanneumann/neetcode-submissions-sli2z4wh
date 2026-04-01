class UnionFind {
   int n;
   vector<int> parent;
   vector<int> rank;

public:
    UnionFind(int n) {
        this->n = n;
        parent.resize(n);
        rank.resize(n);
        for (int i = 0; i< n; i++){
            rank[i] = 1;
            parent[i] = i;
        }
    }

    int find(int x) {
        if (x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
  }

    bool isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    // Union is a reserved keyword in C++, so we use _union instead
    bool _union(int x, int y) {
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
            rank[rootX] += rank[rootY];
        }
        this->n--;
        return true;
    }

    int getNumComponents() {
        return this->n;
    }
};
