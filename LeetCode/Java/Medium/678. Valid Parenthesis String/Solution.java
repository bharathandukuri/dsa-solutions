class Solution {
    public boolean checkValidString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // not cached = 0
        // true = 1
        // false = 2
        dp = new int[n][2 * n + 1];

        return helper(arr, 0, 0);
    }

    int[][] dp;

    private boolean helper(char[] arr, int i, int balance) {
        int n = arr.length;

        if (balance < 0) {
            return false;
        }

        if (i >= n) {
            return balance == 0;
        }

        if (dp[i][n + balance] != 0) {
            return dp[i][n + balance] == 1;
        }

        boolean result;

        if (arr[i] == '(') {
            result = helper(arr, i + 1, balance + 1);
        } else if (arr[i] == ')') {
            result = helper(arr, i + 1, balance - 1);
        } else {
            boolean asOpen = helper(arr, i + 1, balance + 1);
            boolean asClose = helper(arr, i + 1, balance - 1);
            boolean asEmpty = helper(arr, i + 1, balance);

            result = asOpen || asClose || asEmpty;
        }

        dp[i][n + balance] = result ? 1 : 2;
        return result;
    }

}