class Solution {

    char[] arr1, arr2;
    int[][] dp;

    public int minDistance(String word1, String word2) {
        arr1 = word1.toCharArray();
        arr2 = word2.toCharArray();

        dp = new int[word1.length() + 1][word2.length() + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(word1.length() - 1, word2.length() - 1);
    }

    private int dfs(int i, int j) {

        if (i < 0 && j < 0) {
            return 0;
        }

        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        if (dp[i + 1][j + 1] != -1) {
            return dp[i + 1][j + 1];
        }

        if (arr1[i] == arr2[j]) {
            dp[i + 1][j + 1] = dfs(i - 1, j - 1);
        } else {

            int insert = dfs(i, j - 1);
            int delete = dfs(i - 1, j);
            int replace = dfs(i - 1, j - 1);

            dp[i + 1][j + 1] =
                Math.min(Math.min(insert, delete), replace) + 1;
        }

        return dp[i + 1][j + 1];
    }
}