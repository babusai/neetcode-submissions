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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();

        if (root == null) {
            return rightSideView;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        TreeNode node;

        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                node = queue.remove();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (size == 1) {
                    rightSideView.add(node.val);
                }
            }
        }
        return rightSideView;
    }
}
