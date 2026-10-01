class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        if (n == 0) return 0;
        if (n == 1) return 1;

        char[] arr = s.toCharArray();

        int count = 0;

        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && arr[l] == arr[r]) {
                count++;
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < n && arr[l] == arr[r]) {
                count++;
                l--;
                r++;
            }
        }

        return count;
    }
}