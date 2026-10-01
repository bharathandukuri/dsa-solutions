class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        arr = s.toCharArray();
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0, arr.length - 1);
    }

    int[][] dp;
    char[] arr;

    private int helper(int i, int j) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int best = 1 + helper(i + 1, j);

        for (int k = i + 1; k <= j; k++) {
            if (arr[i] == arr[k]) {
                best = Math.min(
                    best,
                    helper(i + 1, k - 1) +
                    helper(k, j)
                );
            }
        }

        return dp[i][j] = best;
    }
}