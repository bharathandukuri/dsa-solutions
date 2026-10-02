class Solution {
    int[][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;

        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return solve(prices, 0, 0);
    }

    private int solve(int[] prices, int i, int state) {
        int n = prices.length;

        if (i >= n) {
            return 0;
        }

        if (dp[i][state] != -1) {
            return dp[i][state];
        }

        int cool = solve(prices, i + 1, state);
        if (state == 0) {
            int buy = solve(prices, i + 1, 1) - prices[i];
            dp[i][state] = Math.max(cool, buy);
        } else {
            int sell = solve(prices, i + 2, 0) + prices[i];
            dp[i][state] = Math.max(cool, sell);
        }

        return dp[i][state];
    }
}