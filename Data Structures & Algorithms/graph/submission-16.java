class Graph {
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    public Graph() {
    }

    public void addEdge(int src, int dst) {
        adj.putIfAbsent(src, new HashSet<>());
        adj.putIfAbsent(dst, new HashSet<>());
        adj.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!adj.containsKey(src) ||!adj.get(src).contains(dst)){
            return false;
        }
            adj.get(src).remove(dst);
 return true;
    }

    public boolean hasPath(int src, int dst) {
        return dfs(src, dst, new HashSet<>(), new HashSet<>());
    }

    boolean dfs(int src, int dst, Set<Integer> visiting, Set<Integer> visited){
        if (src == dst){
            return true;
        }
        visited.add(src);
        for (int neighbor : adj.getOrDefault(src, new HashSet<>())){
            if (!visited.contains(neighbor)){
                if (dfs(neighbor, dst, visiting, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
