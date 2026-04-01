class Solution {
    class Cell {
        int r;
        int c;
        public Cell(int row, int col){
            this.r = row;
            this.c = col;
        }

        @Override
        public boolean equals(Object obj){
            if (obj == null){
                return false;
            }
            Cell cell = (Cell)obj;
            if (r == cell.r && c == cell.c) {
                return true;
            }
            return false; 
        }


        @Override
        public String toString(){
            return r +","+c;
        }
    }
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new ArrayList<>());
    }

    int dfs(int[][] grid, int r, int c, List<String> visited ){
        int rows = grid.length;
        int cols = grid[0].length;
        if (r == rows -1 && c == cols -1 && grid[r][c] != 1){
            return 1;
        }
        if (r == rows || c == cols || r < 0 || c < 0 || grid[r][c] == 1){
            return 0;
        }

        String cell = String.format("%d,%d", r, c);
        if (visited.contains(cell)){
            return 0;
        }
        visited.add(cell);
        int cost = 0;
        cost += dfs(grid, r + 1, c, visited);
        cost += dfs(grid, r - 1, c, visited);
        cost += dfs(grid, r, c + 1, visited);
        cost += dfs(grid, r, c - 1, visited);
        visited.remove(visited.size() - 1);
        return cost;
    }
}
