class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    islands += 1;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m) return;
        if (j < 0 || j >= n) return;

        if (grid[i][j] == '0') return;

        if (visited[i][j]) return;

        visited[i][j] = true;

        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);
    }
}