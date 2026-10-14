
import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class Solution {

    private TrieNode root = new TrieNode();
    private List<List<String>> result = new ArrayList<>();
    private List<String> suggestions;

    public List<List<String>> suggestedProducts(
            String[] products, String searchWord) {

        Arrays.sort(products);

        for (String p : products) {
            insert(p);
        }

        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            prefix.append(c);

            if (node != null) {
                node = node.children[c - 'a'];
            }

            suggestions = new ArrayList<>();

            if (node != null) {
                dfs(new StringBuilder(prefix), node);
            }

            result.add(new ArrayList<>(suggestions));
        }

        return result;
    }

    private void dfs(StringBuilder s, TrieNode node) {
        if (suggestions.size() == 3) {
            return;
        }

        if (node.endOfWord) {
            suggestions.add(s.toString());
        }

        for (int i = 0; i < 26 && suggestions.size() < 3; i++) {
            if (node.children[i] != null) {
                s.append((char) ('a' + i));

                dfs(s, node.children[i]);

                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    private void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }

            node = node.children[c - 'a'];
        }

        node.endOfWord = true;
    }
}
