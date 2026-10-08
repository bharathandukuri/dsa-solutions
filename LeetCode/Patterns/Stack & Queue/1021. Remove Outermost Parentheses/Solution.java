class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (!stack.isEmpty()) {
                    ans.append(s.charAt(i));
                }
                stack.push('(');
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    ans.append(s.charAt(i));
                }
            }
        }
        return ans.toString();
    }
}