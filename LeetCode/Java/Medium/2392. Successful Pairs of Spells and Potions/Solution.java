class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            int first = m;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if ((long) spells[i] * potions[mid] >= success) {
                    first = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            pairs[i] = m - first;
        }

        return pairs;
    }
}