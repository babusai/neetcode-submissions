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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null) {
            return false;
        }

        return isSameSubtree(root, subRoot) || isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }

    private boolean isSameSubtree(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        } else if (first == null || second == null) {
            return false;
        }

        return first.val == second.val && isSameSubtree(first.left, second.left)
            && isSameSubtree(first.right, second.right);
    }
}
