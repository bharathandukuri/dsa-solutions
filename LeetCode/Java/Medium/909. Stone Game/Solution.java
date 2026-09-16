class Solution {

    int[][] dp;

    public boolean stoneGame(int[] piles) {
        dp = new int[piles.length][piles.length];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
        }
        int alice = solve(piles, 0, piles.length - 1);
        int bob = sum - alice;
        return alice > bob;
    }

    private int solve(int[] piles, int i, int j) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        boolean isEven = (j - i + 1) % 2 == 0;
        int left = isEven ? piles[i]: 0;
        int right = isEven ? piles[j]: 0;
        dp[i][j] = Math.max(solve(piles, i + 1, j) + left, solve(piles, i, j - 1) + right);
        return dp[i][j];
    }
}