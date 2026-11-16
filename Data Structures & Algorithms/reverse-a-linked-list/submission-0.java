/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode previous = null;
        ListNode node = head;
        ListNode next = head.next;

        while (next != null) {
            node.next = previous;
            previous = node;
            node = next;
            next = next.next;
        }

        node.next = previous;

        return node;
    }
}
