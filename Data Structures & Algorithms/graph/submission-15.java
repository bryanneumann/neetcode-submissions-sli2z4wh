class Graph {
    class Node {
        int src;
        int dst;
        public Node(){
            src = -1;
            dst = -1;
        }
        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        public Node(int s, int d){
            this.src = s;
            this.dst = d;
        }
    }

    Node graph = new Node();
    public Graph() {

    }

    public void addEdge(int src, int dst) {
        graph.neighbors.putIfAbsent(src, new HashSet<>());
        graph.neighbors.putIfAbsent(dst, new HashSet<>());
        graph.neighbors.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!graph.neighbors.containsKey(src) || !graph.neighbors.containsKey(dst)){
            return false;
        }
        graph.neighbors.get(src).remove(dst);
        return true;
    }

    public boolean hasPath(int src, int dst) {
        return hasPath(src, dst, new HashSet<>());
    }

    public boolean hasPath(int src, int dst, Set<Integer> visited) {
        if (src == dst){
            return true;
        }
        if (!graph.neighbors.containsKey(src) || !graph.neighbors.containsKey(dst)){
            return false;
        }
        visited.add(src);
        for (int neighbor : graph.neighbors.get(src)){
            if (!visited.contains(neighbor)){
            if (hasPath(neighbor, dst, visited)){
                return true;
            }}
        }
        return false;
    }

}
