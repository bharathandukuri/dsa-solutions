class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        cached = new boolean[n][2];
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
        //buy
        if (state == 0) {
            int buy = -prices[i] + helper(prices, i + 1, 1);
            int skip = helper(prices, i + 1, 0);
            result = Math.max(buy, skip);
        } else {
            int sell = prices[i] + helper(prices, i + 2, 0);
            int skip = helper(prices, i + 1, 1);
            result = Math.max(sell, skip);
        }
        return dp[i][state] = result;
    }   
}