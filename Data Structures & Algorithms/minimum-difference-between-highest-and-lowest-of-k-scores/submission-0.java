class Solution {
    public int minimumDifference(int[] nums, int k) {
       int L = 0;
       int min = Integer.MAX_VALUE;
       Arrays.sort(nums);
       for (int R = k - 1; R < nums.length; R++){
          min = Math.min(min, nums[R] - nums[L]);
          L++;
       }
       return min;
    }
}