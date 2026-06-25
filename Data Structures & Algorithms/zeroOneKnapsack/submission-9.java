class Solution {
    int m;
    int n;
    int[][] memo;

    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        m = profit.size();
        n = capacity + 1;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return profit(profit, weight, capacity, 0);
    }

    int profit(List<Integer> profit, List<Integer> weight, int cap, int start) {
        if (cap <= 0 || start == profit.size()) {
            // Out of capacity or out of items
            return 0;
        }
        if (memo[start][cap] != -1) {
            // Return cached value
            return memo[start][cap];
        }
        int profitWithout = profit(profit, weight, cap, start + 1);
        int profitWith = 0;
        // Verify current capacity allows for weight of the current item
        if (cap >= weight.get(start)) {
            // Calculate the profit with the current item adjusting capacity for the weight of the
            // current item.
            profitWith =
                profit.get(start) + profit(profit, weight, cap - weight.get(start), start + 1);
        }
        // Update the cache with the calculated value.
        memo[start][cap] = Math.max(profitWithout, profitWith);
        return memo[start][cap];
    }
}
