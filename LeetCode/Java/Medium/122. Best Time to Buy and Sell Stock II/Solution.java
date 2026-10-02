class Solution {
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        cached = new boolean[prices.length][2];
        return helper(prices, 0, 0);
    }

    int[][] dp;
    boolean[][] cached;

    private int helper(int[] prices, int i, int state) {
        int n = prices.length;

        if (i >= n) {
            return 0;
        }

        if (cached[i][state]) {
            return dp[i][state];
        }

        cached[i][state] = true;
        int result;

        if (state == 0) {
            // Buy OR skip
            int buy = -prices[i] + helper(prices, i + 1, 1);
            int skip = helper(prices, i + 1, 0);
            result = Math.max(buy, skip);
        } else {
            // Sell OR hold
            int sell = prices[i] + helper(prices, i + 1, 0);
            int hold = helper(prices, i + 1, 1);
            result =  Math.max(sell, hold);
        }
        return dp[i][state] = result;
    }
}