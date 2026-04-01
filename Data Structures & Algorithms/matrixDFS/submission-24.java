class Solution {
    int rows;
    int cols;

    public int countPaths(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int paths = 0;
        boolean[][] visited = new boolean[rows][cols];
        return paths(grid, visited, 0, 0);
    }

    int paths(int[][] grid, boolean[][] visited, int r, int c){
        if (r >= rows || c >= cols || r < 0 || c < 0 || visited[r][c] || grid[r][c] == 1 ){
            return 0;
        }

        // If goal reached
        if (r == rows - 1 && c == cols - 1){
          return 1;
        }
         
        visited[r][c] = true;
        int currentPaths = 0;
        currentPaths += paths(grid, visited, r + 1, c);
        currentPaths += paths(grid, visited, r - 1, c);
        currentPaths += paths(grid, visited, r, c + 1);
        currentPaths += paths(grid, visited, r, c - 1);
        visited[r][c] = false;
        return currentPaths;
    }
}
