class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();

        for (String word : wordDict) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }

                node = node.children[idx];
            }

            node.endOfWord = true;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            TrieNode node = root;

            for (int j = i; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a';

                if (node.children[idx] == null)
                    break;

                node = node.children[idx];

                if (node.endOfWord && dp[j + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}