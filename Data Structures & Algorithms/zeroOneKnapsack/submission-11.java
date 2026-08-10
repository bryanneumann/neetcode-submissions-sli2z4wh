class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[][] memo = new int[profit.size() + 1][capacity + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return calcProfit(memo, 0, profit, weight, capacity);
    }

    int calcProfit(
        int[][] memo, int start, List<Integer> profit, List<Integer> weight, int capacity) {
        // Out of capacity or out of items
        if (capacity <= 0 || start == profit.size()) {
            return 0;
        }
        if (memo[start][capacity] != -1) {
            return memo[start][capacity];
        }

        int profitWithout = calcProfit(memo, start + 1, profit, weight, capacity);
        int profitWith = 0;
        // If we have room for the current item
        if (capacity >= weight.get(start)) {
            profitWith = profit.get(start)
                + calcProfit(memo, start + 1, profit, weight, capacity - weight.get(start));
        }
        // Update the cache
        memo[start][capacity] = Math.max(profitWith, profitWithout);
        return memo[start][capacity];
    }
}