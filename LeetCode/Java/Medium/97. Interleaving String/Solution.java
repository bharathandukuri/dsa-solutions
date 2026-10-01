class Solution {

    char[] arr1;
    char[] arr2;
    char[] arr3;

    int l1;
    int l2;
    int l3;

    int[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();

        arr1 = s1.toCharArray();
        arr2 = s2.toCharArray();
        arr3 = s3.toCharArray();

        if (l1 + l2 != l3)
            return false;

        dp = new int[l1 + 1][l2 + 1];
        dp[l1][l2] = 1;

        int i, j, k;

        i = l1 - 1;
        k = l3 - 1;
        while (i >= 0 && k >= 0 && arr1[i] == arr3[k]) {
            dp[i][l2] = 1;
            i--;
            k--;
        }

        j = l2 - 1;
        k = l3 - 1;
        while (j >= 0 && k >= 0 && arr2[j] == arr3[k]) {
            dp[l1][j] = 1;
            j--;
            k--;
        }

        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int k) {
        if (i == l1 || j == l2 || k == l3) {
            return dp[i][j] == 1;
        }

        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }

        boolean bottom = false;
        boolean left = false;

        if (arr1[i] == arr3[k])
            bottom = dfs(i + 1, j, k + 1);

        if (arr2[j] == arr3[k])
            left = dfs(i, j + 1, k + 1);

        dp[i][j] = (bottom || left) ? 1 : 2;

        return dp[i][j] == 1;
    }
}