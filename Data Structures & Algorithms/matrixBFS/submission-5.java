class Solution {
    public int shortestPath(int[][] grid) {
        int[][] dirs = new int[][]{
            {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        int length = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean [][] visited = new boolean[ROWS][COLS];
        while (!q.isEmpty()){
            int qsize = q.size();
            for (int i = 0; i < qsize; i++){
                int[] cur = q.poll();
                int curR = cur[0];
                int curC = cur[1];
                if (curR == ROWS - 1 && curC == COLS - 1){
                    return length;
                }
                
                for (int[] dir : dirs){
                    int newR = curR + dir[0];
                    int newC = curC + dir[1];
                    if (newR < 0 || newC < 0  || newR >= ROWS || newC >= COLS
                        || visited[newR][newC] || grid[newR][newC] == 1){
                            continue;
                    }
                    q.offer(new int[]{newR, newC});
                    visited[newR][newC] = true;
                }
            }
            length++;
        }
       
        return -1;
    }
}
