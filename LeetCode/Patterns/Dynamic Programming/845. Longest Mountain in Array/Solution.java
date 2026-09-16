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

    public int[] lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int result = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return dp;
    }


    public int[] lengthOfLISRev(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int result = 1;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return dp;
    }
}