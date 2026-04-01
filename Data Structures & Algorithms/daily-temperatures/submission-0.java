class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] R = new int[T.length];
        // temp, index
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < T.length; i++){
            int t = T[i];
            while (!stack.isEmpty() && t > stack.peek()[0]){
                int[] cur = stack.pop();
                R[cur[1]] = i - cur[1];
            }
            stack.push(new int[]{t, i});
        }

        return R;
    }
}
