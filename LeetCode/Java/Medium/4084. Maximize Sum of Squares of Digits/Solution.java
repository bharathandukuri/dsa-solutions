class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder s = new StringBuilder();
        int digits = 0;
        while (sum >= 9) {
            s.append('9');
            sum -= 9;
            digits++;
        }
        s.append(String.valueOf(sum));
        digits++;
        for (int i = digits; i < num; i++) {
            s.append('0');
        }
        return s.length() == num ? s.toString() : "";
    }
}