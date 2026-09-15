from collections import Counter

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        freq = Counter(nums)
        for k, v in freq.items():
            if v > 1:
                return True
        return False