class Solution {
    int M;
    int N;
    int[][] memo;

    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        M = profit.size();
        N = capacity;
        memo = new int[M+1][N+1];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        return profit(0, profit, weight, capacity);
    }

    int profit(int i, List<Integer> profit, List<Integer> weight, int capacity){
        if (capacity <= 0 || i == profit.size()){
            // Out of items or capacity
            return 0;
        }
        if (memo[i][capacity] != -1){
            return memo[i][capacity];
        }
        int profitWithoutItem = profit(i + 1, profit, weight, capacity);
        int profitWithItem = 0;
        if (capacity >= weight.get(i)){
            // We have room for this item.
            profitWithItem = profit.get(i) + profit(i + 1, profit, weight, capacity - weight.get(i));
        }
        // Save the result
        memo[i][capacity] = Math.max(profitWithItem, profitWithoutItem);
        return memo[i][capacity];
    }
}
