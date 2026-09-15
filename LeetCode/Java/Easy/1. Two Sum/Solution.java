class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (data.containsKey(target - nums[i])) {
                return new int[] {data.get(target - nums[i]), i};
            } else {
                data.put(nums[i], i);
            }
        }
        return new int[0];
    }
}