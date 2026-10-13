class Trie {

    static class TrieNode {
        TrieNode[] children;
        boolean endOfWord = false;

        public TrieNode() {
            this.children = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
        }
    }

    private TrieNode head;

    public Trie() {
        head = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = head;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode next = temp.children[c - 'a'];
            if (next == null) {
                TrieNode node = new TrieNode();
                temp.children[c - 'a'] = node;
                next = node;
            }
            temp = next;
        }
        temp.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = this.head;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode curr = temp.children[c - 'a'];
            if (curr == null) {
                return false;
            }
            temp = curr;
        }
        return temp.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = this.head;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode curr = temp.children[c - 'a'];
            if (curr == null) {
                return false;
            }
            temp = curr;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */