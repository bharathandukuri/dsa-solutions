class Solution {
    public int longestMountain(int[] nums) {
        int[] lis = lengthOfLIS(nums);
        int[] lisR = lengthOfLISRev(nums);

        int maxMountain = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (lis[i] > 1 && lisR[i] > 1) {
                int mountainLength = lis[i] + lisR[i] - 1;
                maxMountain = Math.max(maxMountain, mountainLength);
            }
        }
        return maxMountain;
    }
}