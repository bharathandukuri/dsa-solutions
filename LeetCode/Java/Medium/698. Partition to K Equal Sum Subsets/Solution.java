class Solution {

    int[] dp;
    int target;
    int k;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total % k != 0) {
            return false;
        }

        target = total / k;
        this.k = k;

        int n = nums.length;

        dp = new int[1 << n];

        return helper(nums, 0, 0);
    }

    private boolean helper(int[] nums, int mask, int sum) {

        if (mask == (1 << nums.length) - 1) {
            return true;
        }

        if (dp[mask] != 0) {
            return dp[mask] == 2;
        }

        for (int i = 0; i < nums.length; i++) {

            // Already used
            if ((mask & (1 << i)) != 0) {
                continue;
            }

            // Can't exceed current subset
            if (sum + nums[i] > target) {
                continue;
            }

            int nextMask = mask | (1 << i);

            int nextSum = sum + nums[i];

            // Completed a subset
            if (nextSum == target) {
                nextSum = 0;
            }

            if (helper(nums, nextMask, nextSum)) {
                dp[mask] = 2;
                return true;
            }
        }

        dp[mask] = 1;
        return false;
    }
}