class Solution {
    public boolean checkValidString(String s) {
        char[] arr = s.toCharArray();
        return helper(arr, 0, 0);
    }

    private boolean helper(char[] arr, int i, int balance) {
        int n = arr.length;
        if (i >= n) {
            if (balance != 0) {
                return false;
            }
            return true;
        }

        if (arr[i] == '(' || arr[i] == ')') {
            int change = arr[i] == '(' ? 1 : -1;
            balance = balance + change;
            return helper(arr, i + 1, balance);
        }

        boolean res1 = helper(arr, i + 1, balance + 1);
        boolean res2 = helper(arr, i + 1, balance - 1);
        boolean res3 = helper(arr, i + 1, balance);
        return res1 || res2 || res3;
    }

}