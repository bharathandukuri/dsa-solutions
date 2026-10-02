class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // Rob current node, so skip both children
        int rob = root.val + left[1] + right[1];

        // Skip current node, children can be robbed or skipped
        int skip = Math.max(left[0], left[1])
                 + Math.max(right[0], right[1]);

        return new int[]{rob, skip};
    }
}
