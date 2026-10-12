class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;

            for (int target = square; target <= n; target++) {
                dp[target] = Math.min(
                    dp[target],
                    dp[target - square] + 1
                );
            }
        }

        return dp[n];
    }
}