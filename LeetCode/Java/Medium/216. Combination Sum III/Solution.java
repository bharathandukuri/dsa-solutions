
import java.util.*;

class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private Deque<Integer> stack = new ArrayDeque<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        result.clear();
        backtrack(1, k, n);
        return result;
    }

    private void backtrack(int start, int k, int n) {
        if (k == 0) {
            if (n == 0) {
                result.add(new ArrayList<>(stack));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > n) break;

            stack.addLast(i);
            backtrack(i + 1, k - 1, n - i);
            stack.removeLast();
        }
    }
}
