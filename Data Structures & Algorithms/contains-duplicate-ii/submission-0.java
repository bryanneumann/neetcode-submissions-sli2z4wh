class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
     Set<Integer> window = new HashSet<>(); // Cur window of size <= k
    int L = 0;
    for (int R = 0; R < nums.length; R++) {
        if (Math.abs(R - L) > k) {
            window.remove(nums[L]);
            L++;
        }
        if (window.contains(nums[R])) {
            return true;
        }
        window.add(nums[R]);
    }
    return false;    
    }
}