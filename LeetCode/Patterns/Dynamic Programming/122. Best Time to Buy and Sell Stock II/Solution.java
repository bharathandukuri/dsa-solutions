class Solution {
    private int[][] dp;
    private boolean[][] cached;

    public int maxProfit(int[] prices) {
        int n = prices.length;

        dp = new int[n][2];
        cached = new boolean[n][2];

        return helper(prices, 0, 0);
    }

    private int helper(int[] prices, int i, int state) {
        if (i == prices.length) {
            return 0;
        }

        if (cached[i][state]) {
            return dp[i][state];
        }

        cached[i][state] = true;

        if (state == 0) {
            int buy = -prices[i] + helper(prices, i + 1, 1);
            int skip = helper(prices, i + 1, 0);

            return dp[i][state] = Math.max(buy, skip);
        }

        int sell = prices[i] + helper(prices, i + 1, 0);
        int hold = helper(prices, i + 1, 1);

        return dp[i][state] = Math.max(sell, hold);
    }
}