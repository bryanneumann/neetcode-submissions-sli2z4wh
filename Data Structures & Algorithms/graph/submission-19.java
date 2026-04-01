class Graph {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    public Graph() {
    }

    public void addEdge(int src, int dst) {
        graph.putIfAbsent(src, new HashSet<>());
        graph.putIfAbsent(dst, new HashSet<>());
        graph.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!graph.containsKey(src) || !graph.containsKey(dst)){
            return false;
        }
        graph.get(src).remove(dst);
        graph.remove(src);

        return true;
    }

    public boolean hasPath(int src, int dst) {
        Set<Integer> visited = new HashSet<>();
        return hasPathDfs(src, dst, visited);
    }

    public boolean hasPathDfs(int src, int dst, Set<Integer> visited) {
        if (src == dst){
            return true;
        }
                // if (!graph.containsKey(src)){
        //     return false;
        // }
        // if (!graph.containsKey(dst)) {
        //     return false;
        // }
        visited.add(src);
        for (int neighbor : graph.getOrDefault(src, new HashSet<>())){
            if (!visited.contains(neighbor)){
                if (hasPathDfs(neighbor, dst, visited)){
                    return true;
                }
            }
        }

        return false; 
    }
}
