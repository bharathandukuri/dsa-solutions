class Solution {
    public int longestMountain(int[] nums) {
        int longest = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            longest = Math.max(longest, lengthOfMountain(nums, i));
        }

        return longest;
    }

    private int lengthOfMountain(int[] nums, int peak) {
        int i = peak - 1;
        int j = peak + 1;
        while (i >= 0 && nums[i] < nums[i + 1]) {
            i--;
        }
        while (j < nums.length && nums[j] > nums[j - 1]) {
            j++;
        }
        int diff = j - i - 1;

        if (diff <= 2) {
            return 0;
        }
        return diff + 2;
    }
}