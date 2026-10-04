class Solution {
    public boolean checkValidString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // not cached = 0
        // true = 1
        // false = 2
        dp = new int[n][n + 2];


        return helper(arr, 0, 0);
    }

    int[][] dp;
    boolean[][] cached;

    private boolean helper(char[] arr, int i, int balance) {
        int n = arr.length;
        int half = n / 2 + 1;

        if (i >= n) {
            if (balance != 0) {
                return false;
            }
            return true;
        }

        if (dp[i][half + balance] != 0) {
            return dp[i][half + balance] == 1 ? true : false;
        }

        if (arr[i] == '(' || arr[i] == ')') {
            int change = arr[i] == '(' ? 1 : -1;
            balance = balance + change;
            return helper(arr, i + 1, balance);
        }

        boolean res1 = helper(arr, i + 1, balance + 1);
        boolean res2 = helper(arr, i + 1, balance - 1);
        boolean res3 = helper(arr, i + 1, balance);
        boolean result = res1 || res2 || res3;
        dp[i][half + balance] = result ? 1 : 2;
        return result;
    }

}