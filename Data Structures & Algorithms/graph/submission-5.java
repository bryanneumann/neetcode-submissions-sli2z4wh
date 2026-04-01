class Graph {
    class GraphNode{
        int src = -1;
        int dst = -1;
        public GraphNode(int s, int d){
            src = s;
            dst = d;
        }
        Map<Integer, GraphNode> neighbors = new HashMap<>();
    }
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    public Graph() {

    }

    public void addEdge(int src, int dst) {
        adj.putIfAbsent(src, new HashSet<>());
        adj.putIfAbsent(dst, new HashSet<>());
        adj.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (adj.containsKey(src)){
            if (adj.get(src).contains(dst)){
                Set<Integer> list = adj.get(src);
                if (list.contains(dst)){
                    adj.get(src).remove(dst);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPath(int src, int dst) {
        return hasPathDfs(src, dst, new HashSet<>());
    }

    boolean hasPathDfs(int src, int dst, Set<Integer> visited){
        if (visited.contains(src) || src == dst){
            return true;
        }
        visited.add(src);
        for (int neighbor :  adj.getOrDefault(src, Collections.emptySet())){
            if (hasPathDfs(neighbor, dst, visited)){
                return true;
            }
        }
        return false;
    }
}
