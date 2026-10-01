class Solution {
    public int strangePrinter(String s) {
        char[] arr = s.toCharArray();
        return helper(arr, 0, arr.length - 1);
    }

    private int helper(char[] arr, int i, int j) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            return 1;
        }

        int best = 1 + helper(arr, i + 1, j);

        for (int k = i + 1; k <= j; k++) {
            if (arr[i] == arr[k]) {
                best = Math.min(
                    best,
                    helper(arr, i + 1, k - 1) +
                    helper(arr, k, j)
                );
            }
        }

        return best;
    }
}