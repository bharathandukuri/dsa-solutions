class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] available = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            available[i] = digits[i].charAt(0) - '0';
        }

        dp = new HashMap<>();

        return helper(available, n, 0);
    }

    Map<Integer, Integer> dp;

    private int helper(int[] available, int n, int prefix) {
        int result = 0;

        if (dp.containsKey(prefix)) {
            return dp.get(prefix);
        }

        for (int i = 0; i < available.length; i++) {
            int digit = available[i];

            int temp = prefix * 10 + digit;

            if (temp > n) {
                continue;
            }

            result++;

            if (temp <= n / 10) {
                result += helper(available, n, temp);
            }
        }

        dp.put(prefix, result);

        return result;
    }
}