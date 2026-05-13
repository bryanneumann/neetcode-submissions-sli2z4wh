class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
      int[][] memo = new int[profit.size()][capacity + 1];
      for (int[] row : memo){
        Arrays.fill(row, -1);
      }
      return profit(memo, 0, profit, weight, capacity);
    }

    int profit(int[][] memo, int index, List<Integer> profit, List<Integer> weight, int cap){
      // Base case: out of items or out of capacity. 
      if (index == profit.size() || cap <= 0){
       return 0; 
      }
      // If cell is not -1, we can return its value
      if (memo[index][cap] != -1){
        return memo[index][cap];
      }

      // Skip this item
      int profit1 = profit(memo, index + 1, profit, weight, cap);

      // Include this item
      int profit2 = 0;
      // If we have room for this item
      if (cap >= weight.get(index)){
        profit2 = profit.get(index) + profit(memo, index + 1, profit, weight, cap - weight.get(index) );
      }

      return memo[index][cap] = Math.max(profit1, profit2);
    }
}
