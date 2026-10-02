class Solution {
    public int maxProfit(int[] prices, int fee) {
        return helper(prices, fee, 0, 0);
    }

    private int helper(int[] prices, int fee, int i, int state) {
        int n = prices.length;
        if (i >= n) {
            return 0;
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
        return best;
    }
}