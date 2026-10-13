class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] stack = new int[n];
        int top = -1;

        int[] out = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int t = temperatures[i];
            while (top > -1 && temperatures[stack[top]] <= t) {
                top--;
            }

            if (top < 0) {
                out[i] = 0;
            } else {
                out[i] = stack[top] - i;
            }
            stack[++top] = i;
        }

        return out;
    }
}