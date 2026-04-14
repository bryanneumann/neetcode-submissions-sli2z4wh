class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, src});
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
        while (!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int n1 = cur[1];
            int w1 = cur[0];
            if (distances.containsKey(n1)){
                continue;
            }
            distances.put(n1, w1);
            for (int[] neighbor : adj.get(n1)){
                int n2 = neighbor[0];
                int w2 = neighbor[1];
                if (!distances.containsKey(n2)){
                    minHeap.offer(new int[]{w1 + w2, n2});
                }
            }
        }
        for (int i = 0; i < n; i++){
            distances.putIfAbsent(i, -1);
        } 
        return distances;
    }  
}
