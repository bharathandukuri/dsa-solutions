class Solution {

    int[][][] dp;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;

        int total = 0;

        for (int i = 0; i < n; i++) {
            total += nums[i];
        }

        if (total % k != 0) {
            return false;
        }

        int target = total / k;

        dp = new int[1 << n][k + 1][target + 1];

        return helper(nums, 0, 0, k, 0, target);
    }

    public boolean helper(
            int[] nums,
            int mask,
            int i,
            int k,
            int sum,
            int target) {

        if (k == 0) {
            return true;
        }

        if (i >= nums.length) {
            return false;
        }

        if (dp[mask][k][sum] != 0) {
            return dp[mask][k][sum] == 1 ? false : true;
        }

        // Skip
        boolean skip = helper(
                nums,
                mask,
                i + 1,
                k,
                sum,
                target
        );

        // Take
        boolean take = false;

        if ((mask & (1 << i)) == 0 &&
                sum + nums[i] <= target) {

            boolean matches = sum + nums[i] == target;

            int nextMask = mask | (1 << i);

            int nextK = matches ? k - 1 : k;
            int nextI = matches ? 0 : i + 1;
            int nextSum = matches ? 0 : sum + nums[i];

            take = helper(
                    nums,
                    nextMask,
                    nextI,
                    nextK,
                    nextSum,
                    target
            );
        }

        boolean result = skip || take;

        dp[mask][k][sum] = result ? 2 : 1;

        return result;
    }
}