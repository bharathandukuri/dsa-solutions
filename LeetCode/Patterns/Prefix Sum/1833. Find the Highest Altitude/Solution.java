class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] prefix = new int[n];
        prefix[0] = gain[0];

        int high = Math.max(prefix[0], 0);

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + gain[i];
            high = Math.max(prefix[i], high);
        }   
        return high;
    }
}