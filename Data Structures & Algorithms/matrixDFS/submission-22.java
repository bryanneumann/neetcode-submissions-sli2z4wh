class Solution {
    int rows;
    int cols;
    List<List<String>> paths = new ArrayList<>();
    public int countPaths(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        if (grid[0][0] == 1 || grid[rows-1][cols-1] == 1){
            return 0;
        }
        int count = dfs(grid, 0, 0, new ArrayList<>(), new HashSet<>());
        return count;
    }

    int dfs(int[][] grid, int r, int c, List<String> path, Set<String> visited){
        if (r < 0 || c < 0 || r == rows || c == cols || visited.contains(String.format("%s,%s",r,c)) ||
            grid[r][c] == 1){
                return 0;

        }
        if (r == rows - 1 && c == cols - 1){
            return 1;
        }

        visited.add(String.format("%s,%s", r, c));

        int count = 0;
        count += dfs(grid, r + 1, c, path, visited);
        count += dfs(grid, r - 1, c, path, visited);
        count += dfs(grid, r, c + 1, path, visited);
        count += dfs(grid, r, c - 1, path, visited);
        
        visited.remove(String.format("%s,%s", r, c));
        return count;
    }
}
