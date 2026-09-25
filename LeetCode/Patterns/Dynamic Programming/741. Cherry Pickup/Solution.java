class Solution {
    private int[][][] dp;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        dp = new int[n][n][n];

        for (int[][] row2D : dp) {
            for (int[] row1D : row2D) {
                Arrays.fill(row1D, -2);
            }
        }

        int ans = dfs(grid, 0, 0, 0, n);
        return Math.max(0, ans);
    }

    private int dfs(int[][] grid, int r1, int c1, int r2, int n) {
        int c2 = r1 + c1 - r2;

        // Boundary checks
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n) {
            return -1;
        }

        // Thorns / blocked paths
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -1;
        }

        // Destination reached
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2] != -2) {
            return dp[r1][c1][r2];
        }

        // Cherries collected at the current synchronized step
        int cherries = (r1 == r2 && c1 == c2) 
            ? grid[r1][c1] 
            : grid[r1][c1] + grid[r2][c2];

        // 4 possible simultaneous moves:
        // 1. Both Down
        // 2. Person 1 Down, Person 2 Right
        // 3. Person 1 Right, Person 2 Down
        // 4. Both Right
        int bestNext = Math.max(
            Math.max(dfs(grid, r1 + 1, c1, r2 + 1, n), dfs(grid, r1 + 1, c1, r2, n)),
            Math.max(dfs(grid, r1, c1 + 1, r2 + 1, n), dfs(grid, r1, c1 + 1, r2, n))
        );

        if (bestNext == -1) {
            return dp[r1][c1][r2] = -1;
        }

        return dp[r1][c1][r2] = cherries + bestNext;
    }
}