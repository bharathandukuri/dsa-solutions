
import java.util.Arrays;

class Solution {

    int[][] dp;

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (m > n) {
            return 0;
        }

        dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(s.toCharArray(), t.toCharArray(), 0, 0);
    }

    private int helper(char[] s, char[] t, int i, int j) {
        if (j == t.length) {
            return 1;
        }

        if (i == s.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int count = 0;

        if (s[i] == t[j]) {
            count += helper(s, t, i + 1, j + 1);
        }

        count += helper(s, t, i + 1, j);

        return dp[i][j] = count;
    }
}
