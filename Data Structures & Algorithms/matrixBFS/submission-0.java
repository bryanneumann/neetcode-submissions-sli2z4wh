class Solution {
    final int[][] D = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    public int shortestPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid == null || grid.length == 0){
            return -1;
        }
        Set<String> visit = new HashSet<>();
        int cost = 0; 
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visit.add("0,0");
        while (!q.isEmpty()){
            int qsize = q.size();
            for (int i =0; i < qsize; i++){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            if (r == rows - 1 && c == cols - 1){
                return cost;
            }
            for (int[] dir : D){
                int newR = dir[0] + r;
                int newC = dir[1] + c;
                if ( Math.min(newR, newC) < 0 || newR == rows  || newC == cols || grid[newR][newC] == 1 || visit.contains( newR + "," + newC) ){
                    continue;

                }
                q.add(new int[]{newR, newC});
                visit.add(newR + "," + newC);
             }
        }
            cost++;

        }
        return -1;
    }
}
