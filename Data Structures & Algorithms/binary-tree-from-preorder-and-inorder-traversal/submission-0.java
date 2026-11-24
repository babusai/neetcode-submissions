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
    int pIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int index = 0; index < inorder.length; index++) {
            valueToIndex.put(inorder[index], index);
        }
        return buildTree(preorder, inorder, 0, inorder.length - 1, valueToIndex);
    }

    private TreeNode buildTree(
        int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> valueToIndex) {
        if (start > end) {
            return null;
        }

        if (pIndex == preorder.length) {
            return null;
        }

        int value = preorder[pIndex++];
        int inorderRoot = valueToIndex.get(value);
        TreeNode node = new TreeNode(value);
        node.left = buildTree(preorder, inorder, start, inorderRoot - 1, valueToIndex);
        node.right = buildTree(preorder, inorder, inorderRoot + 1, end, valueToIndex);

        return node;
    }
}
