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
    int position;
    Integer kthSmallest;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return kthSmallest;    
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if(node == null) {
            return;
        }

        inOrderTraversal(node.left, k);
        
        position++;
        if(position == k) {
            kthSmallest = node.val;
            return;
        }

        inOrderTraversal(node.right, k);
    }
}
