class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] padding = new int[n + 2];
        padding[0] = 1;
        padding[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            padding[i + 1] = nums[i];
        }

        dp = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(padding, 1, n);
    }

    int[][] dp;

    private int helper(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int best = 0;

        for (int k = i; k <= j; k++) {

            int cost = nums[i - 1] * nums[k] * nums[j + 1];

            int left = helper(nums, i, k - 1);
            int right = helper(nums, k + 1, j);

            best = Math.max(best, cost + left + right);
        }

        return dp[i][j] = best;
    }
}