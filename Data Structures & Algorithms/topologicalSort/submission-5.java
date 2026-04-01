class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges){
            int src = edge[0];
            int dst = edge[1];
            adj.get(src).add(dst);
        }
        List<Integer> top = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        for (int i = 0; i < n; i++){
            if (!dfs(i, adj, visited, visiting, top)){
                return new ArrayList<>();
            }
        }
        Collections.reverse(top);
        return top;
    }

//  public List<Integer> topologicalSort(int n, int[][] edges) {
//         Map<Integer, List<Integer>> adj = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             adj.put(i, new ArrayList<>());
//         }
//         for (int[] edge : edges) {
//             adj.get(edge[0]).add(edge[1]);
//         }

//         List<Integer> topSort = new ArrayList<>();
//         Set<Integer> visited = new HashSet<>();
//         Set<Integer> visiting = new HashSet<>();

//         for (int i = 0; i < n; i++) {
//             if (!dfs(i, adj, visited, visiting, topSort)) {
//                 return new ArrayList<>(); // Return empty list if a cycle is detected
//             }
//         }

//         Collections.reverse(topSort);
//         return topSort;
//     }

    boolean dfs(int src, Map<Integer, List<Integer>> adj, Set<Integer> visited, Set<Integer> visiting, List<Integer> topSort){
        if (visited.contains(src)){
            return true;
        }
        if (visiting.contains(src)){
            return false; // Cycle detected.
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
            if (!dfs(neighbor, adj, visited, visiting, topSort)){
                return false; // Cycle detected
            }
        }
        visiting.remove(src);
        visited.add(src);
        topSort.add(src);
        return true; // No cycle
    }
}
