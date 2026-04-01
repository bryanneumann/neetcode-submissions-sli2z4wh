class Graph {
    class Edge{
        int src = 0;
        int dst = 0;

        public Edge(int s, int d){
            this.src = s; 
            this.dst = d;
        }
    }
    Map<Integer, HashSet<Integer> > adj = new HashMap<>();
    public Graph() {
    }

    public void addEdge(int src, int dst) {
        adj.putIfAbsent(src, new HashSet<>());
        adj.putIfAbsent(dst, new HashSet<>());
        adj.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!hasPath(src, dst)){
            return false;
        }
        if (adj.containsKey(src)){
            adj.get(src).remove(dst);
        }
        if (adj.containsKey(dst)){
            adj.get(dst).remove(src);
        }
         return !hasPath(src, dst);
    }

    public boolean hasPath(int src, int dst) {
        return hasPathDfs(src, dst, new HashSet<>());
    }

    private boolean hasPathDfs(int src, int dst, Set<Integer> visited){
        if (src == dst){
            return true;
        }
        visited.add(src);
        for (int neighbor : adj.getOrDefault(src, new HashSet<>())){
            if (!visited.contains(neighbor)){
                if (hasPathDfs(neighbor, dst, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
