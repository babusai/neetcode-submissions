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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < q.val) {
            return lca(root, p, q);
        }

        return lca(root, q, p);
    }

    private TreeNode lca(TreeNode node, TreeNode smaller, TreeNode bigger) {
        
        if(node == null) {
            return null;
        }
        
        if(node.val > smaller.val && node.val > bigger.val) {
            return lca(node.left, smaller, bigger);
        } else if(node.val < smaller.val && node.val < bigger.val) {
            return lca(node.right, smaller, bigger);
        }

        TreeNode left = lca(node.left, smaller, bigger);

        if(node == smaller || node == bigger) {
            return node;
        }

        TreeNode right = lca(node.right, smaller, bigger);

        if(left == smaller && right == bigger) {
            return node;
        }

        return left != null ? left : right;
    }
}
