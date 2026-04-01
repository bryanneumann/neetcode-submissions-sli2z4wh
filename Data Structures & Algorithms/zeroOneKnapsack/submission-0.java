class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        return dfs(0, profit, weight, capacity);
    }

    int dfs(int i, List<Integer> profit,
     List<Integer> weight, int capacity){
        if (i == profit.size()){
            return 0;
        }
        // Exclude the current item i
        int maxProfit = dfs(i + 1, profit, weight, capacity);

        // Include the current item i 
        int newCap = capacity - weight.get(i);
        if (newCap >= 0){
            int p = profit.get(i) + dfs(i + 1, profit, weight, newCap);
            maxProfit = Math.max(maxProfit, p);
        }
        return maxProfit;
    }
}
