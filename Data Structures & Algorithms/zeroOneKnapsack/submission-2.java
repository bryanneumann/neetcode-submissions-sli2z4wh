class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
      int M = capacity; 
      int N = profit.size(); // Number of items
      List<int[]> cache = new ArrayList<>();
      for (int i = 0; i < N; i++){
        int[] row = new int[M + 1];
        Arrays.fill(row, -1); // Mark each sell as not visited
        cache.add(row);
      }
      return dfs_memo(0, profit, weight, capacity, cache);
    }

    // Top-down memoization solution 
    // O(M * N) runtime; O(M * N) space. Tradeoff between speed and space
    int dfs_memo(int i, List<Integer> profit, List<Integer> weight, int cap, List<int[]> cache){
        if (i == profit.size()){
            // Base case
            return 0;
        }
        if (cache.get(i)[cap] != -1){
           return cache.get(i)[cap]; 
        }
        // Exclude i
        cache.get(i)[cap] = dfs_memo(i + 1, profit, weight, cap, cache);

        // Include i
        int newCap = cap - weight.get(i);
        if (newCap >= 0){
           cache.get(i)[cap] = Math.max(cache.get(i)[cap],
             profit.get(i) + dfs_memo(i + 1, profit, weight, newCap, cache)); 
        }
        return cache.get(i)[cap];
    }

    // Brute force version O(2^n) runtime and O(n) space
    int dfs(int i, List<Integer> profit, List<Integer> weight, int cap){
        if (i == profit.size()){
            // Base case
            return 0;
        }
        // Decision to not include i
        int maxProfit = dfs(i + 1, profit, weight, cap);

        // Decision to include i
        int newCap = cap - weight.get(i);
        if (newCap >= 0){
            maxProfit = Math.max(maxProfit, profit.get(i) + dfs(i + 1, profit, weight, newCap));
        }
        return maxProfit; 
    }
}
