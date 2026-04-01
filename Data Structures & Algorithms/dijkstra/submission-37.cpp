class Solution {
public:
    unordered_map<int, int> shortestPath(int n, vector<vector<int>>& edges, int src) {
      unordered_map<int,int> distances;
      map<int, vector<pair<int,int>>> adj;
      for (int i = 0; i < n; i++){
        adj[i] = vector<pair<int,int>>();
      }

      for (vector<int>& edge : edges){
        int s = edge[0];
        int d = edge[1];
        int w = edge[2];
        adj[s].push_back({d, w});
      }
      priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> min_heap;
      min_heap.push({0, src});
      while (!min_heap.empty()){
        pair<int,int> cur = min_heap.top();
        min_heap.pop();
        int n1 = cur.second;
        int w1 = cur.first;
        if (distances.find(n1) != distances.end()){
            continue;
        }
        distances[n1] = w1;
        for (pair<int,int> neighbor : adj[n1]){
            int n2 = neighbor.first;
            int w2 = neighbor.second;
            if (distances.find(n2) == distances.end()){
                min_heap.push({w1 + w2, n2});
            }
        }
      }
      for (int i = 0; i < n; i++){
        if (distances.find(i) == distances.end()){
            distances[i] = -1;
        }
      }
      return distances;
    }
};
