class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }

        if (total % k != 0) {
            return false;
        }

        int target = total / k;

        boolean[] used = new boolean[n];

        return helper(nums, used, 0, k, 0, target);
    }

    public boolean helper(
            int[] nums,
            boolean[] used,
            int i,
            int k,
            int sum,
            int target) {

        if (k == 0) {
            return true;
        }

        if (i >= nums.length) {
            return false;
        }

        // Skip
        boolean skip = helper(
                nums, used, i + 1, k, sum, target);

        // Take
        boolean take = false;

        if (!used[i] && sum + nums[i] <= target) {

            boolean matches = sum + nums[i] == target;

            used[i] = true;

            if (matches) {
                k--;
            }

            int idx = matches ? 0 : i + 1;
            int nextSum = matches ? 0 : sum + nums[i];

            take = helper(
                    nums, used, idx, k, nextSum, target);

            // Backtrack
            used[i] = false;

            if (matches) {
                k++;
            }
        }

        return skip || take;
    }
}