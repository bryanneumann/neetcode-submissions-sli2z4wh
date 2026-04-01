class Solution {
    int rows, cols;
    public int countPaths(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();         
        Set<String> visited = new HashSet<>();
        return dfs(grid, 0, 0, visited, paths, path);

    }

    int dfs(int[][] grid, int r, int c, Set<String> visited, List<List<Integer>> paths, List<Integer> path){
       if (r >= rows || c >= cols || r < 0 || c < 0) {
        return 0;
       }

       if (grid[r][c] == 1) {
        return 0;
       }
       if (visited.contains(r +"," +c)){
        return 0;
       }
       if (r == rows - 1 && c == cols - 1){
        return 1;
       }
       visited.add(r + "," + c);
       int unique = 0;
       unique +=dfs(grid, r +1, c, visited, paths, path);
       unique +=dfs(grid, r -1, c, visited, paths, path);
       unique +=dfs(grid, r, c + 1, visited, paths, path);
       unique +=dfs(grid, r, c - 1, visited, paths, path);
       visited.remove(r + "," + c);
       return unique; 
    }
}
