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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        StringBuilder serialized = new StringBuilder();

        String num = null;
        TreeNode node;

        while (!queue.isEmpty()) {
            for (int position = queue.size(); position > 0; position--) {
                node = queue.remove();
                if (!serialized.isEmpty()) {
                    serialized.append(",");
                }
                serialized.append(node != null ? node.val : node);
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        System.out.println(serialized.toString());
        return serialized.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        String[] levelOrder = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(levelOrder[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        TreeNode node = null;

        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                node = queue.remove();
                if (node != null) {
                    if (!"null".equals(levelOrder[index])) {
                        node.left = new TreeNode(Integer.valueOf(levelOrder[index]));
                        queue.offer(node.left);
                    }
                    if (!"null".equals(levelOrder[index + 1])) {
                        node.right = new TreeNode(Integer.valueOf(levelOrder[index + 1]));
                        queue.offer(node.right);
                    }
                }
                index += 2;
            }
        }

        return root;
    }
}
