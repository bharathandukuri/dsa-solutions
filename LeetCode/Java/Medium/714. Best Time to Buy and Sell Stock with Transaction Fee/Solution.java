class Solution {
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return helper(prices, fee, 0, 0);
    }
    
    int[][] dp;

    private int helper(int[] prices, int fee, int i, int state) {
        int n = prices.length;
        if (i >= n) {
            return 0;
        }

        if (dp[i][state] != -1) {
            return dp[i][state];
        }

        int best;
        if (state == 0) {
            int buy = -prices[i] + helper(prices, fee, i + 1, 1);
            int skip = helper(prices, fee, i + 1, 0);
            best = Math.max(buy, skip);
        } else {
            int sell = prices[i] + (-fee) + helper(prices, fee, i + 1, 0);
            int skip = helper(prices, fee, i + 1, 1);
            best = Math.max(sell, skip);
        }
        return dp[i][state] = best;
    }
}