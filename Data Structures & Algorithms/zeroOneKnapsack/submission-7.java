class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
      int[][] memo = new int[profit.size()][capacity + 1];
      for (int[] row : memo){
        Arrays.fill(row, -1);
      }
      return profit(memo, profit, weight, capacity, 0);
    }

    int profit(int[][] memo, List<Integer> profit, List<Integer> weight, int cap, int i){
      // Base case: either out of capacity or out of items
      if (cap <= 0 || i == profit.size()){
       return 0; 
      }
      // Base case: we have the value cached
      if (memo[i][cap] != -1){
        return memo[i][cap];
      } 

      // Try without the current item
      int p1 = profit(memo, profit, weight, cap, i + 1);

      int p2 = 0;
      if (cap >= weight.get(i)) {
      // We have capacity, so try with the current item
        p2 = profit.get(i) +  profit(memo, profit, weight, cap - weight.get(i), i+1);
      }

      // Update the cached value to the max profit 
      memo[i][cap] = Math.max(p1, p2);
      return memo[i][cap];
    }
}
