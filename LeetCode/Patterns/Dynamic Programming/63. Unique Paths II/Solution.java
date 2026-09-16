class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i == m - 1 && j == n - 1) continue;
                if (obstacleGrid[i][j] == 1) continue;

                int bottom = i + 1 < m && obstacleGrid[i + 1][j] != 1 ? dp[i + 1][j] : 0;
                int right = j + 1 < n && obstacleGrid[i][j + 1] != 1  ? dp[i][j + 1] : 0;
                dp[i][j] = bottom + right;
            }
        }
        return dp[0][0];
    }
}