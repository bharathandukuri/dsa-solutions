class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int s = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            if (map.containsKey(s - k)) {
                count += map.get(s - k);
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        return count;
    }
}