class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder s = new StringBuilder();

        while (num > 0) {
            int digit = Math.min(9, sum);
            s.append(digit);
            sum -= digit;
            num--;
        }

        if (sum > 0) {
            return "";
        }

        return s.toString();
    }
}