class Solution {
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new Boolean[m][n][m + n + 1];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int balance) {
        int m = grid.length;
        int n = grid[0].length;

        if (r >= m || c >= n) {
            return false;
        }

        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        if (dp[r][c][balance] != null) {
            return dp[r][c][balance];
        }

        return dp[r][c][balance] =
            dfs(grid, r + 1, c, balance) ||
            dfs(grid, r, c + 1, balance);
    }
}