class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] available = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            available[i] = digits[i].charAt(0) - '0';
        }

        return helper(available, n, 0);
    }

    private int helper(int[] available, int n, int prefix) {
        int result = 0;

        for (int digit : available) {
            int temp = prefix * 10 + digit;

            if (temp > n) {
                continue;
            }

            // temp itself is a valid number
            result++;

            // Can we append another digit?
            if (temp <= n / 10) {
                result += helper(available, n, temp);
            }
        }

        return result;
    }
}