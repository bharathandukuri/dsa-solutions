class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        if (n == 0) return "";

        int start = 0, end = 0;
        int length = 1;

        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            //Odd length
            int l = i, r = i;
            while (l >= 0 && r < n && arr[l] == arr[r]) {
                int newLen = r - l + 1;
                if (newLen > length) {
                    start = l;
                    end = r;
                    length = newLen;
                }
                l--;
                r++;
            }

            //Even length
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && arr[l] == arr[r]) {
                int newLen = r - l + 1;
                if (newLen > length) {
                    start = l;
                    end = r;
                    length = newLen;
                }
                l--;
                r++;
            }
        }

        if (length == 0) return "";
        
        return s.substring(start, end + 1);
    }
}