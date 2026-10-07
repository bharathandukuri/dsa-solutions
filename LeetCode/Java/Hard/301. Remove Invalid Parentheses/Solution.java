class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean found = false;

            // Process one BFS level
            for (int k = 0; k < size; k++) {

                String curr = queue.poll();

                if (isValid(curr)) {
                    result.add(curr);
                    found = true;
                }

                // If we already found valid strings at this level,
                // don't generate the next level.
                if (found) {
                    continue;
                }

                // Remove one parenthesis
                for (int i = 0; i < curr.length(); i++) {

                    if (curr.charAt(i) != '(' &&
                        curr.charAt(i) != ')') {
                        continue;
                    }

                    String next =
                        curr.substring(0, i) +
                        curr.substring(i + 1);

                    if (visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }

            if (found) {
                return result;
            }
        }

        return result;
    }

    private boolean isValid(String s) {

        int balance = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                balance++;
            } else if (c == ')') {

                if (balance == 0) {
                    return false;
                }

                balance--;
            }
        }

        return balance == 0;
    }
}