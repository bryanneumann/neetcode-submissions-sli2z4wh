class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, Integer> distances = new HashMap<>();
        List<Integer> sorted = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (List<Integer> edge : edges){
            int s = edge.get(0);
            int d = edge.get(1);
            int w = edge.get(2);
            adj.get(s).add(new int[]{d, w});
        }
      
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new Integer[]{0, src});
        while (!minHeap.isEmpty()){
            Integer[] curr = minHeap.poll();
            int n1 = curr[1];
            int w1 = curr[0];
            if (visited.contains(n1)){
                continue;
            }
            visiting.add(n1);
            distances.put(n1, w1);
            for (int[] edge : adj.get(n1)){
                int n2 = edge[0];
                int w2 = edge[1];
                if (!distances.containsKey(n2)){
                    minHeap.offer(new Integer[]{w1 + w2, n2});
                }
            }
            visiting.remove(n1);
            visited.add(n1);
            sorted.add(n1);
        }
        for (int i = 0; i < n; i++){
            distances.putIfAbsent(i, -1);
        }
        return distances;
    }
}
