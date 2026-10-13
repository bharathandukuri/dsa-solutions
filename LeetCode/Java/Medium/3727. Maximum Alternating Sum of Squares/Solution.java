class Solution {
    public long maxAlternatingSum(int[] nums) {
        Arrays.sort(nums);

        long sum = 0;
        int n = nums.length;

        // The absolute values determine the square sizes.
        int[] squares = new int[n];

        for (int i = 0; i < n; i++) {
            squares[i] = Math.abs(nums[i]);
        }

        Arrays.sort(squares);

        for (int i = 0; i < n; i++) {
            long square = 1L * squares[i] * squares[i];

            if (i < n / 2) {
                sum -= square;
            } else {
                sum += square;
            }
        }

        return sum;
    }
}