class Solution {
    int[][] dp;

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        //adding padding 0 at both starting and ending
        int[] points = new int[m + 2];

        points[0] = 0;
        points[m + 1] = n;

        for (int i = 0; i < m; i++) {
            points[i + 1] = cuts[i];
        }

        Arrays.sort(points);

        dp = new int[m + 2][m + 2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(points, 0, m + 1);
    }

    private int helper(int[] points, int l, int r) {
        if (r - l <= 1) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = l + 1; i < r; i++) {

            int cost = points[r] - points[l];

            int left = helper(points, l, i);
            int right = helper(points, i, r);

            minCost = Math.min(
                minCost,
                cost + left + right
            );
        }

        return dp[l][r] = minCost;
    }
}