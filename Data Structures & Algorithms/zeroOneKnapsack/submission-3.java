class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
       List<int[]> cache = new ArrayList<>();
       for (int i = 0; i < profit.size(); i++){
         int[] row = new int[capacity + 1];
         Arrays.fill(row, -1);
         cache.add(row);
       }
       return dfs(0, profit, weight, capacity, cache); 
    }

    int dfs(int i, List<Integer> profit, List<Integer> weight, int capacity, List<int[]> cache){
       if (i == profit.size()) {
          return 0;
       }
       if (cache.get(i)[capacity] != -1){
         return cache.get(i)[capacity];
       }
       // Exclude i
       cache.get(i)[capacity] = dfs(i + 1, profit, weight, capacity, cache);
       // Include i
       int newCapacity = capacity - weight.get(i);
       if (newCapacity > -1){
         int newProfit = dfs(i + 1, profit, weight, newCapacity, cache) + profit.get(i);
         cache.get(i)[capacity] = Math.max(cache.get(i)[capacity], newProfit);
       }
       return cache.get(i)[capacity];
    }
}
