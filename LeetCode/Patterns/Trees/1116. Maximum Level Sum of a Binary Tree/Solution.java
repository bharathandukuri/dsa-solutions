/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.Arrays;

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        int bestLevel = 1;
        int level = 0;
        int maxSum = root.val;

        TreeNode[] queue = new TreeNode[] { root };

        while (queue.length > 0) {
            level++;
            int sum = 0;

            TreeNode[] temp = new TreeNode[queue.length * 2];
            int idx = 0;

            for (TreeNode node : queue) {
                if (node == null) continue;
                sum += node.val;
                if (node.left != null)  temp[idx++] = node.left;
                if (node.right != null) temp[idx++] = node.right;
            }

            if (sum > maxSum) {
                maxSum = sum;
                bestLevel = level;
            }

            if (idx == 0) break;

            queue = Arrays.copyOf(temp, idx);
        }

        return bestLevel;
    }
}
