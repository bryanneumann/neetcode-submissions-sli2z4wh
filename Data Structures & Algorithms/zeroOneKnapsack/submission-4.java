class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
       int[][] cache = new int[profit.size()][capacity + 1];
       for (int[] row : cache){
         Arrays.fill(row, -1);
       }
       return maxProfit(profit, weight, capacity, 0, cache);
    }

    int maxProfit(List<Integer> profit, List<Integer> weight, int capacity, int index, int[][] cache){
      // Base case: out of items or out of capacity.
      if (index == profit.size() || capacity <=0){
        return 0;
      }
      // Return cached result if we have it
      if (cache[index][capacity] != -1){
        return cache[index][capacity];
      }

      // Skip this item
      int mp1 = maxProfit(profit, weight, capacity, index + 1, cache);

      // Include this item
      int mp2 = 0;
      if (capacity >= weight.get(index)){ 
        mp2 = profit.get(index) + maxProfit(profit, weight, capacity - weight.get(index), index + 1, cache);
      }
      // Pick the best profit from the two options and save the result.
      return cache[index][capacity] = Math.max(mp1, mp2);
    }
}
