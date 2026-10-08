class Solution {
    int n;
    int[][] dp;
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        n = nums.length;
        dp = new int[target + 1][n];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return knapsack(nums, target, 0, 0) == target;
    }

    private int knapsack(int[] nums, int target, int i, int sum) {
        if (i == n) {
            return 0;
        }
        if (sum > target) {
            return 0;
        }

        if (dp[sum][i] != -1) {
            return dp[sum][i];
        }

        int take = 0;
        if (nums[i] + sum <= target) {
            take = knapsack(nums, target, i + 1, sum + nums[i]) + nums[i];
        }
        int skip = knapsack(nums, target, i + 1, sum);
        return dp[sum][i] = Math.max(take, skip);
    }
}