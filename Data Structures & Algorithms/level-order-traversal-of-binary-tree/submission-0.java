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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null) {
            return levelOrder;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();

        List<Integer> level = new ArrayList<>();

        queue.offer(root);
        level.add(root.val);
        levelOrder.add(level);

        TreeNode current;
        int size = level.size();
        while(!queue.isEmpty()) {
            current = queue.remove();
            size--;
            if(size == 0) {
                size = level.size();
                level = null;
            }

            if(current.left != null) {
                if(level == null) {
                    level = new ArrayList<>();
                    levelOrder.add(level);
                }
                queue.offer(current.left);
                level.add(current.left.val);
            }
            if(current.right != null) {
                if(level == null) {
                    level = new ArrayList<>();
                    levelOrder.add(level);
                }
                queue.offer(current.right);
                level.add(current.right.val);
            }
        }

        return levelOrder;
    }
}
