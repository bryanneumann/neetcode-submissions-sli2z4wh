class Solution {
    public int shortestPath(int[][] grid) {
        int shortestLen = 0;
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dirs = new int[][]{
            {0, 1},
            {0,-1},
            {1, 0},
            {-1, 0}
        };
        int rows = grid.length;
        int cols = grid[0].length;
        q.offer(new int[]{0,0});
        boolean[][] visited = new boolean[rows][cols];

        while (!q.isEmpty()){
            int qSize = q.size();
            for (int i = 0; i < qSize; i++){ 
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            if (curR == rows - 1 && curC == cols - 1){
                return shortestLen;
            }
            for (int j = 0; j < dirs.length; j++){
               int newR = curR + dirs[j][0];
               int newC = curC + dirs[j][1];
               if (newR < 0 || newC < 0 || newR >= rows ||
                newC >= cols || grid[newR][newC] == 1 || visited[newR][newC]){
                 continue;
               }
               visited[newR][newC] = true;
               q.offer(new int[]{newR, newC}) ;
            }
        }
          shortestLen++;
        }
        return -1;
    }
}
