class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[32];

        for (int num : nums) {
            for (int bit = 0; bit < 32; bit++) {
                if ((num & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
        }


        long ans = 0;
        long MOD = 1_000_000_007L;

        for (int i = 0; i < k; i++) {
            int num = 0;

            for (int bit = 0; bit < 32; bit++) {
                if (bitCount[bit] > 0) {
                    num = num | (1 << bit);
                    bitCount[bit]--;
                }
            }

            ans = (ans + (num * num)) % MOD;
        }

        return (int) (ans);

    }
}