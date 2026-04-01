class Solution {
    int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int shortestPath(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        q.add(new int[]{0, 0});
        boolean[][] visited = new boolean[rows][cols];
        // Set<String> visited = new HashSet<>();
        // visited.add("0,0");
        visited[0][0] = true;
        int length = 0;
        while (!q.isEmpty()){
            int qSize = q.size();
            for (int i = 0; i < qSize; i++){
                int[] cur = q.poll(); 
                int curR = cur[0];
                int curC = cur[1];
                if (curR == rows -1 && curC == cols -1){ // Done
                    return length; 
                }
                for (int[] dir : dirs){
                    int newR = curR + dir[0];
                    int newC = curC + dir[1];
                    if (newR < 0 || newC < 0 || newR == rows || newC == cols || grid[newR][newC] == 1 
                    || visited[newR][newC]){
                    //|| visited.contains(newR + "," + newC)){
                        continue;
                    }
                    q.add(new int[]{ newR, newC});
                    visited[newR][newC] = true;
                    //visited.add(newR +"," + newC);
                }
            }
            length++;
        }
       
       // Path not possible
        return -1;
    }
}
