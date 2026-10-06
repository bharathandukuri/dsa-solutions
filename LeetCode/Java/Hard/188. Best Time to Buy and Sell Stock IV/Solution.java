class Solution {
    public int maxProfit(int k, int[] prices) {
        dp = new int[prices.length][k][2];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(prices, 0, 0, 0, k);
    }

    int[][][] dp;

    private int helper(int[] prices, int i, int transactions, int state, int k) {
        int n = prices.length;

        if (i >= n) {
            return 0;
        }

        if (transactions == k && state == 0) {
            return 0;
        }

        if (dp[i][transactions][state] != -1) {
            return dp[i][transactions][state];
        }

        int skip = helper(prices, i + 1, transactions, state, k);

        int best;

        if (state == 0) {
            int buy = -prices[i]
                    + helper(prices, i + 1, transactions, 1, k);

            best = Math.max(skip, buy);

        } else {
            // Sell
            int sell = prices[i]
                    + helper(prices, i + 1, transactions + 1, 0, k);

            best = Math.max(skip, sell);
        }

        return dp[i][transactions][state] = best;
    }
}