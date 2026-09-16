class Solution {
    public int longestMountain(int[] nums) {
        int longest = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                longest = Math.max(longest, lengthOfMountain(nums, i));
            }
        }
        return longest;
    }

    private int lengthOfMountain(int[] nums, int peak) {
        int i = peak - 1;
        int j = peak + 1;

        while (i >= 0 && nums[i] < nums[i + 1]) {
            i--;
        }
        i++; 

        while (j < nums.length && nums[j] < nums[j - 1]) {
            j++;
        }
        j--;

        return j - i + 1;
    }
}