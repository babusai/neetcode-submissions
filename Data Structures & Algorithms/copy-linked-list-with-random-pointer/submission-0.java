/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> sourceToTarget = new HashMap<>();
        Node current = head;
        Node node;
        while (current != null) {
            node = new Node(current.val);
            sourceToTarget.put(current, node);
            current = current.next;
        }

        Node source;
        Node target;
        for (Map.Entry<Node, Node> entry : sourceToTarget.entrySet()) {
            source = entry.getKey();
            target = entry.getValue();

            target.next = sourceToTarget.get(source.next);
            target.random = sourceToTarget.get(source.random);
        }

        return sourceToTarget.get(head);
    }
}
