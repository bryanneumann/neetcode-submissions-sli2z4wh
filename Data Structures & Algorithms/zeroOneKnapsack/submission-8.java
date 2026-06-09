class Solution {

    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[][] memo = new int[profit.size()][capacity + 1];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        return profit(memo, 0, profit, weight, capacity);
    }
    int profit(int[][] memo, int start, List<Integer> profit, List<Integer> weight, int capacity){
        if (capacity <= 0 || start == profit.size()){
           // If out of capacity or items stop
           return 0; 
        }

        if (memo[start][capacity] != -1){
            // Value is already cached
            return memo[start][capacity];
        }

        // Try without item
        int profitWithout = profit(memo, start + 1, profit, weight, capacity);

        int profitWith = 0;
        if (capacity >= weight.get(start)){
            // We have capacity for the current item
            profitWith = profit.get(start) + profit(memo, start + 1,
                profit, weight, capacity - weight.get(start));
        }
        // Commit the value to the cache
        memo[start][capacity] = Math.max(profitWithout, profitWith);
        return memo[start][capacity];
    }
}