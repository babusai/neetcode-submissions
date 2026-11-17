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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        for (int index = 0; index < n; index++) {
            node = node.next;
        }

        if (node == null) {
            ListNode newHead = head.next;
            head.next = null;
            head = newHead;
            return head;
        }

        int position = 0;
        while (node != null) {
            node = node.next;
            position++;
        }

        node = head;
        while (position > 1) {
            position--;
            node = node.next;
        }

        ListNode temp = node.next;
        node.next = node.next.next;
        temp.next = null;

        return head;
    }
}
