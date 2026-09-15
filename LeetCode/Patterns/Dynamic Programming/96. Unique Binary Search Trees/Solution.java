class Solution {
    public int numTrees(int n) {
        int[][] dp = new int[n][n];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, n - 1, dp);
    }

    private int helper(int l, int h, int[][] dp) {
        if (l > h) {
            return 1;
        }

        if (dp[l][h] != -1) {
            return dp[l][h];
        }

        int ways = 0;
        for (int i = l; i <= h; i++) {
            int left = helper(l, i - 1, dp);
            int right = helper(i + 1, h, dp);
            ways += left * right;
        }
        return dp[l][h] = ways;
    }
}