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

class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    private int goodNodes(TreeNode node, Integer max) {
        if (node == null) {
            return 0;
        }

        if (node.val >= max) {
            return 1 + goodNodes(node.left, node.val) + goodNodes(node.right, node.val);
        }

        return goodNodes(node.left, max) + goodNodes(node.right, max);
    }
}
