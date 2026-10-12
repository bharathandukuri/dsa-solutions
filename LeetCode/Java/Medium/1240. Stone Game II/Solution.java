import java.util.Arrays;

class Solution {

    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(piles, 0, 1);
    }

    private int helper(int[] piles, int index, int m) {
        if (index >= n) {
            return 0;
        }

        if (dp[index][m] != -1) {
            return dp[index][m];
        }

        int best = 0;

        for (int x = 1; x <= 2 * m && index + x <= n; x++) {
            int opponent = helper(
                piles,
                index + x,
                Math.max(m, x)
            );

            best = Math.max(best, suffix[index] - opponent);
        }

        return dp[index][m] = best;
    }
}