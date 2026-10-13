class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int low = 1, high = max;
        int minSpeed = max;

        while (low <= high) {
            int mid = (low + high) / 2;
            long hoursNeeded = 0;

            for (int pile : piles) {
                hoursNeeded += (long) ((pile + mid - 1) / mid);
            }

            if (hoursNeeded <= h) {
                minSpeed = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minSpeed;
    }
}
