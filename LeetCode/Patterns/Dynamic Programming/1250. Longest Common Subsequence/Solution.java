class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();

        int m = arr1.length;
        int n = arr2.length;

        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = (arr1[m - 1] == arr2[n - 1]) ? 1: 0; 

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;
                boolean match = arr1[i] == arr2[j];
                int next = match ? dp[i + 1][j + 1] : Math.max(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = next + (match ? 1 : 0);
            }
        }
        return dp[0][0];
    }
}