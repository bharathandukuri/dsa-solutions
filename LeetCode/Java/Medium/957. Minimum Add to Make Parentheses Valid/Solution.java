class Solution {
    public int minAddToMakeValid(String s) {
        int c = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                c += 1;
            } else {
                c -= 1;
            }
        }
        return Math.abs(c);
    }
}