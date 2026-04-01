class UnionFind {
public:
    int n;
    vector<int> rank;
    vector<int> parent;
    UnionFind(int n_){
        n = n_;
        parent.resize(n);
        rank.resize(n, 1);
        for (int i = 0; i< n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
      if (x != parent[x]){
        // Path compression
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
        n--;
        return true;
    }

    int getNumComponents() {
        return n;
    }
};
