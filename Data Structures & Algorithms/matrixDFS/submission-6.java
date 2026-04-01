class Solution {
    int rows;
    int cols;
    public int countPaths(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        return dfs(grid, 0, 0, visited);
    }

    int dfs(int[][] grid, int r, int c, boolean[][] visited){
        if (r < 0 || c < 0 || r >= rows || c >= cols || visited[r][c] || grid[r][c] == 1){
            return 0;
        }
      
        if (r == rows - 1 && c == cols - 1){
            return 1;
        }
        int paths = 0;
        visited[r][c] = true;
        paths += dfs(grid, r + 1, c, visited);
        paths += dfs(grid, r - 1, c, visited);
        paths += dfs(grid, r, c + 1, visited);
        paths += dfs(grid, r, c - 1, visited);
        visited[r][c] = false;
        return paths;
    }
}
