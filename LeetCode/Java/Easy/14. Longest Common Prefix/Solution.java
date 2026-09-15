class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder out = new StringBuilder();
        int len = strs[0].length();
        for (String s: strs) {
            len = Math.min(s.length(), len);
        }
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return out.toString();
                }
            }
            out.append(c);
        }
        return out.toString();
    }
}