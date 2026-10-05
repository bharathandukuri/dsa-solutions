class Solution {
    int m, n;
    int[][] dirs = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 }
    };
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int path = lip(matrix, i, j);
                ans = Math.max(path, ans);
            }
        }

        return ans;
    }

    private int getKey(int i, int j) {
        return i * 100 + j;
    }

    private int lip(int[][] matrix, int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int result = 1;

        for (int[] d : dirs) {
            int a = i + d[0];
            int b = j + d[1];


            if (a < 0 || a >= m || b < 0 || b >= n) {
                continue;
            }

            if (matrix[i][j] < matrix[a][b]) {
                result = Math.max(
                    result,
                    1 + lip(matrix, a, b)
                );
            }
        }

        return dp[i][j] = result;
    }
}