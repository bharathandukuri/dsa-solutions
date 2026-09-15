class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        freq1 = {}
        for i in s:
            if i not in freq1:
                freq1[i] = 0
            freq1[i] += 1
        
        freq2 = {}
        for i in t:
            if i not in freq2:
                freq2[i] = 0
            freq2[i] += 1
        
        return freq1 == freq2
        