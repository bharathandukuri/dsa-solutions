import java.util.Arrays;

class Solution {

    int[][] dp;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return helper(piles, 0, n - 1) > 0;
    }

    private int helper(int[] piles, int i, int j) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int takeLeft = piles[i] - helper(piles, i + 1, j);
        int takeRight = piles[j] - helper(piles, i, j - 1);

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }
}