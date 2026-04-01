class Solution {
    int ROWS, COLS;
    public int countPaths(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(grid, 0, 0, visited);
    }

    int dfs(int[][] grid, int r, int c, boolean[][] visited ){
       if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visited[r][c] || grid[r][c] == 1){
            return 0;
        }
        if (r == ROWS - 1 && c == COLS - 1){
           return 1;    
        }
 
        visited[r][c]=true;
        int count = 0;
        count += dfs(grid, r, c + 1, visited);
        count += dfs(grid, r, c - 1, visited);
        count += dfs(grid, r + 1, c, visited);
        count += dfs(grid, r - 1, c, visited);
        visited[r][c]=false;
        return count;
    }
}
 