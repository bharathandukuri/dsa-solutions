class Solution {
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        return dfs(arr, 0, 0, 0, 0);
    }

    private int dfs(char[] arr, int i, int open, int close, int length) {
        int n = arr.length;
        
        if (i >= n) {
            if (open == close) {
                return length;
            }

            return 0;
        }

        //take
        int take = 0;
        if (arr[i] == '(') {
            take = dfs(arr, i + 1, open + 1, close, length + 1);
        } else if (close < open) {
            take = dfs(arr, i + 1, open, close + 1, length + 1);
        }


        int skip = dfs(arr, i + 1, open, close, length);
        return Math.max(take, skip);
    }
}