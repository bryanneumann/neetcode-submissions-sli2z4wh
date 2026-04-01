class Solution {

    int rows, cols;
    public int countPaths(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visit = new boolean[rows][cols];
        int count = 0;
        return dfs(grid, 0, 0, visit);
    }

    int dfs(int[][] grid, int r, int c, boolean[][] visit){
        if (r >= rows|| c >= cols || r < 0 || c < 0 || visit[r][c] || grid[r][c] == 1){
            return 0;
        }
        if (r == rows - 1 && c == cols - 1){
            return 1;
        }
        visit[r][c] = true;
        int cost = 0;
        cost += dfs(grid, r + 1, c, visit);
        cost += dfs(grid, r - 1, c, visit);
        cost += dfs(grid, r, c + 1, visit);
        cost += dfs(grid, r, c - 1, visit);
        visit[r][c] = false;
        return cost;
    }
}
