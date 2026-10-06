class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();

        int operations = 0;

        Deque<Character> stack = new LinkedList<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (arr[i] == '(') {
                stack.push(arr[i]);
            } else {
                if (stack.isEmpty()) {
                    operations++;
                    continue;
                }
                stack.pop();
            }
        }
        return stack.size() + operations;
    }
}