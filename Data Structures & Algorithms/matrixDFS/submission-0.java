class Solution {
    public int countPaths(int[][] grid) {
        int[][] visit = new int[grid.length][grid[0].length];
        return dfs(grid, 0, 0, visit);
    }

    int dfs(int[][] grid, int row, int col, int[][] visit){
        int ROWS = grid.length;
        int COLS = grid[0].length;
        if (row >= ROWS || col >= COLS || Math.min(row, col) < 0 || visit[row][col] == 1 || grid[row][col] == 1){
            return 0;
        }
        if (row == ROWS - 1 && col == COLS - 1){
            return 1;
        }
        visit[row][col] = 1;
        int cost = 0;
        cost += dfs(grid, row + 1, col, visit);
        cost += dfs(grid, row - 1, col, visit);
        cost += dfs(grid, row, col + 1, visit);
        cost += dfs(grid, row, col - 1, visit);
        visit[row][col] = 0;
        return cost;
    }
}
