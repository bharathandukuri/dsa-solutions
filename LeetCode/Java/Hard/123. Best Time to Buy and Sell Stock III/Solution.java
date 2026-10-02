class Solution {
    public int maxProfit(int[] prices) {
        return helper(prices, 0, 0, 0);
    }

    private int helper(int[] prices, int i, int transactions, int state) {
        int n = prices.length;

        if (i >= n) {
            return 0;
        }

        // Already completed 2 transactions.
        // We cannot start another transaction.
        if (transactions == 2 && state == 0) {
            return 0;
        }

        int skip = helper(prices, i + 1, transactions, state);

        int best;

        if (state == 0) {
            // Buy
            int buy = -prices[i]
                    + helper(prices, i + 1, transactions, 1);

            best = Math.max(skip, buy);

        } else {
            // Sell
            int sell = prices[i]
                    + helper(prices, i + 1, transactions + 1, 0);

            best = Math.max(skip, sell);
        }

        return best;
    }
}