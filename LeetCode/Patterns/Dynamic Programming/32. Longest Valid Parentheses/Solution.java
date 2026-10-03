class Solution {
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();

        dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(arr, 0, 0, 0, 0);
    }

    int[][] dp;

    private int dfs(char[] arr, int i, int open, int close, int length) {
        int n = arr.length;
        
        if (i >= n) {
            if (open == close) {
                return length;
            }
            return 0;
        }

        if (dp[i][open - close] != -1) {
            return dp[i][open - close];
        }

        //take
        int take = 0;
        if (arr[i] == '(') {
            take = dfs(arr, i + 1, open + 1, close, length + 1);
        } else if (close < open) {
            take = dfs(arr, i + 1, open, close + 1, length + 1);
        }


        int skip = dfs(arr, i + 1, 0, close, length);
        return dp[i][open - close] = Math.max(take, skip);
    }
}