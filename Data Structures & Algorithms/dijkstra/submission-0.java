class Solution {
     public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
    
        // s = src, d = dst, w = weight
        for (List<Integer> edge : edges) {
            int s = edge.get(0), d = edge.get(1), w = edge.get(2);
            adj.get(s).add(new int[]{d, w});
        }
    
        // Compute shortest paths
        Map<Integer, Integer> shortest = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, src});
    
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int w1 = curr[0], n1 = curr[1];
    
            if (shortest.containsKey(n1)){
	            continue;
            } 
            shortest.put(n1, w1);
            for (int[] edge : adj.get(n1)) {
                int n2 = edge[0], w2 = edge[1];
                if (!shortest.containsKey(n2)) {
                    minHeap.offer(new int[]{w1 + w2, n2});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            shortest.putIfAbsent(i, -1);
        }
    
        return shortest;
    }  
}
