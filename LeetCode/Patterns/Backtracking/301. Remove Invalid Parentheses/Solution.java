class Solution {
    Set<String> result;
    int removals = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        result = new HashSet<>();

        helper(s.toCharArray(), 0, new StringBuilder(), 0);

        return new ArrayList<>(result);
    }

    private void helper(char[] arr, int i,
                         StringBuilder sb, int balance) {

        if (i == arr.length) {

            if (balance == 0) {
                int curr = arr.length - sb.length();

                if (curr < removals) {
                    removals = curr;
                    result.clear();
                    result.add(sb.toString());

                } else if (curr == removals) {
                    result.add(sb.toString());
                }
            }

            return;
        }

        char c = arr[i];

        if (c != '(' && c != ')') {
            sb.append(c);
            helper(arr, i + 1, sb, balance);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        // Take
        if (c == '(') {

            sb.append(c);
            helper(arr, i + 1, sb, balance + 1);
            sb.deleteCharAt(sb.length() - 1);

        } else if (c == ')') {

            // Take ')' only if it can be matched
            if (balance > 0) {
                sb.append(c);
                helper(arr, i + 1, sb, balance - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        // Skip
        helper(arr, i + 1, sb, balance);
    }
}