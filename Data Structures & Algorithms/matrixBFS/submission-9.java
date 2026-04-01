class Solution {
    public int shortestPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited.add("0,0");
        int length = 0;
        int[][] neighbors = {{1,0},{0,1},{0,-1},{-1,0}};
        while (!q.isEmpty()){
           final int qlen = q.size();
            for (int i = 0; i < qlen; i++){
               int[] cell = q.poll(); 
               int r = cell[0];
               int c = cell[1];
               if (r == rows - 1 && c == cols -1){
                    return length;
               }
                for (int[] neighbor : neighbors){
                    int newR = neighbor[0] + r;
                    int newC = neighbor[1] + c;
                    if (newR <0 || newC < 0|| newR == rows || newC == cols || visited.contains(String.format("%s,%s", newR, newC)) || grid[newR][newC] == 1){
                        continue;
                    }
                    q.add(new int[]{newR, newC});
                    visited.add(String.format("%s,%s", newR, newC));
                }
            }
            length++;
        }
        return -1; 
    }
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return String.format("%s,%s", x,y);
        }
    }
}
