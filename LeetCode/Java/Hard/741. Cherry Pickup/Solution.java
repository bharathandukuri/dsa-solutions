class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        dp = new int[n][n][n][n];

        for (int[][][] a : dp)
            for (int[][] b : a)
                for (int[] c : b)
                    Arrays.fill(c, -2);

        int result = dfs(grid, 0, 0, n - 1, n - 1);

        return result == -1 ? 0 : result;
    }

    int[][][][] dp;

    int[][] dirs1 = { { 0, 1 }, { 1, 0 } };
    int[][] dirs2 = { { -1, 0 }, { 0, -1 } };

    private int dfs(int[][] grid, int r1, int c1, int r2, int c2) {
        int n = grid.length;

        //check for out of bounds
        if (r1 >= n || c1 >= n ||
                r2 < 0 || r2 >= n ||
                c2 < 0 || c2 >= n) {
            return -1;
        }

        if (dp[r1][c1][r2][c2] != -2) {
            return dp[r1][c1][r2][c2];
        }

        //blocked cases
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return -1;

        int ch1 = grid[r1][c1];
        int ch2 = (r1 != r2 || c1 != c2) ? grid[r2][c2] : 0;
        grid[r1][c1] = 0;
        grid[r2][c2] = 0;

        //both reached final state
        if (r1 == n - 1 && c1 == n - 1 && r2 == 0 && c2 == 0) {
            grid[r1][c1] = ch1;
            grid[r2][c2] = ch2;
            return ch1 + ch2;
        }

        int best = -1;

        for (int[] d1 : dirs1) {
            int a = r1 + d1[0];
            int b = c1 + d1[1];

            for (int[] d2 : dirs2) {
                int x = r2 + d2[0];
                int y = c2 + d2[1];

                best = Math.max(best, dfs(grid, a, b, x, y));
            }
        }

        grid[r1][c1] = ch1;
        grid[r2][c2] = ch2;

        if (best == -1) {
            return dp[r1][c1][r2][c2] = -1;
        }

        return dp[r1][c1][r2][c2] = best + ch1 + ch2;
    }
}