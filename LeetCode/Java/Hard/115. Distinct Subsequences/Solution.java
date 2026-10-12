class Solution {
    public int numDistinct(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        return helper(s1, s2, 0, 0);
    }

    private int helper(char[] s1, char[] s2, int i, int j) {
        int n1 = s1.length;
        int n2 = s2.length;

        if (j >= n2) {
            return 1;
        }

        if (i >= n1) {
            return 0;
        }

        int count = 0;
        
        //matching
        if (s1[i] == s2[j]) {
            count += helper(s1, s2, i + 1, j + 1);
        }

        //not matching
        count += helper(s1, s2, i + 1, j);
        return count;
    }
}