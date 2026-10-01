class Solution {
    static int matrixMultiplication(int arr[]) {
        n = arr.length;
        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(arr, 1, n - 1);
    }

    static int n;
    static int[][] dp;

    static int dfs(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int best = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            int left = dfs(arr, i, k);
            int right = dfs(arr, k + 1, j);

            int multiplyCost = arr[i - 1] * arr[k] * arr[j];

            best = Math.min(
                best,
                left + right + multiplyCost
            );
        }

        return dp[i][j] = best;
    }
}