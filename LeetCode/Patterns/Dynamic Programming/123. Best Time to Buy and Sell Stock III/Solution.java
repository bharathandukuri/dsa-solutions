class Solution {
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2][2];

        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }

        return helper(prices, 0, 0, 0);
    }

    int[][][] dp;

    private int helper(int[] prices, int i, int transactions, int state) {
        int n = prices.length;

        if (i >= n) {
            return 0;
        }

        if (transactions == 2 && state == 0) {
            return 0;
        }

        if (dp[i][transactions][state] != -1) {
            return dp[i][transactions][state];
        }

        int skip = helper(prices, i + 1, transactions, state);

        int best;

        if (state == 0) {
            int buy = -prices[i]
                    + helper(prices, i + 1, transactions, 1);

            best = Math.max(skip, buy);

        } else {
            // Sell
            int sell = prices[i]
                    + helper(prices, i + 1, transactions + 1, 0);

            best = Math.max(skip, sell);
        }

        return dp[i][transactions][state] = best;
    }
}