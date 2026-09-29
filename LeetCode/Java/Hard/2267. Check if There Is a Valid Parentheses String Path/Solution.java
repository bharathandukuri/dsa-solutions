class Solution {
    public boolean hasValidPath(char[][] grid) {
        return dfs(grid, 0, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int open, int close) {
        int m = grid.length;
        int n = grid[0].length;

        if (r >= m || c >= n) {
            return false;
        }

        if (grid[r][c] == '(') {
            open++;
        } else {
            close++;
        }

        if (close > open) {
            return false;
        }

        if (r == m - 1 && c == n - 1) {
            return open == close;
        }

        return dfs(grid, r + 1, c, open, close) ||
                dfs(grid, r, c + 1, open, close);
    }
}