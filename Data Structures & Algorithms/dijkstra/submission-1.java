class Solution {
    class Node implements Comparable<Node>{
        int weight;
        int node;
        public Node(int w, int n){
            this.weight = w;
            this.node = n;
        }
        int weight(){
            return weight;
        }

        @Override
        public int compareTo(Node n){
            return weight - n.weight;
        }
    }

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
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        //Comparator.comparingInt(Node::weight));
        minHeap.offer(new Node(0, src));
        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            int w1 = curr.weight;
            int n1 = curr.node;

            if (shortest.containsKey(n1)){
	            continue;
            } 
            shortest.put(n1, w1);
            for (int[] edge : adj.get(n1)) {
                int n2 = edge[0], w2 = edge[1];
                if (!shortest.containsKey(n2)) {
                    minHeap.offer(new Node(w1 + w2, n2));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            shortest.putIfAbsent(i, -1);
        }
        return shortest;
    }  
}
