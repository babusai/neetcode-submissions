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

    Integer min;
    Integer max;

    public boolean isValidBST(TreeNode root) {
        return preOrderTraversal(root);
    }

    private boolean preOrderTraversal(TreeNode node) {
        if(node == null) {
            return true;
        }

        if(node.left == null && node.right == null) {
            min = node.val;
            max = node.val;
            return true;
        }

        // min = null;
        // max = null;

        boolean left = preOrderTraversal(node.left);

        if(!left) {
            return left;
        }

        if(max != null && max >= node.val) {
            return false;
        }

        Integer leftMin = min;
        Integer leftMax = max;

        min = null;
        max = null;

        boolean right = preOrderTraversal(node.right);

        if(!right) {
            return right;
        }

        if(min != null && min <= node.val) {
            return false;
        }

        min = leftMin != null ? leftMin : node.val;
        max = max == null ? node.val : max;

        return true;
    }
}
