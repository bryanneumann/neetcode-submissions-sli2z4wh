class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>( (a,b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, src});
        for (int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (List<Integer> edge : edges){
            int n1 = edge.get(0);
            int n2 = edge.get(1);
            int w = edge.get(2);
            adj.get(n1).add(new int[]{n2, w});
        }
        while (!minHeap.isEmpty()){
            int qlen = minHeap.size();
            for (int i = 0; i < qlen; i++){
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
        }
        for (int i = 0; i < n; i++){
            distances.putIfAbsent(i, -1);
        }
        return distances;
    }  
}
