class Solution {
    private int[][][] dp;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        dp = new int[2 * n - 1][n][n];

        for (int k = 0; k < 2 * n - 1; k++) {
            for (int r1 = 0; r1 < n; r1++) {
                Arrays.fill(dp[k][r1], Integer.MIN_VALUE);
            }
        }

        int result = dfs(grid, 0, 0, 0);

        return Math.max(0, result);
    }

    private int dfs(int[][] grid, int k, int r1, int r2) {
        int n = grid.length;

        int c1 = k - r1;
        int c2 = k - r2;

        // Out of bounds
        if (r1 >= n || c1 >= n ||
            r2 >= n || c2 >= n) {
            return Integer.MIN_VALUE;
        }

        // Thorn
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        // Reached destination
        if (k == 2 * n - 2) {
            return grid[r1][c1];
        }

        if (dp[k][r1][r2] != Integer.MIN_VALUE) {
            return dp[k][r1][r2];
        }

        int cherries = grid[r1][c1];

        // Don't count same cell twice
        if (r1 != r2 || c1 != c2) {
            cherries += grid[r2][c2];
        }

        int best = Math.max(
            dfs(grid, k + 1, r1 + 1, r2 + 1),
            Math.max(
                dfs(grid, k + 1, r1 + 1, r2),
                Math.max(
                    dfs(grid, k + 1, r1, r2 + 1),
                    dfs(grid, k + 1, r1, r2)
                )
            )
        );

        if (best == Integer.MIN_VALUE) {
            return dp[k][r1][r2] = Integer.MIN_VALUE;
        }

        return dp[k][r1][r2] = cherries + best;
    }
}