class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char[] arr = s.toCharArray();
        Map<Character, Character> pairs = Map.of(')', '(', '}', '{', ']', '[');

        for (char c: arr) {
            if (pairs.containsKey(c)) {
                if (deque.isEmpty() || deque.pop() != pairs.get(c)) {
                    return false;
                }
            } else {
                deque.push(c);
            }
        }
        return deque.isEmpty();
    }
}