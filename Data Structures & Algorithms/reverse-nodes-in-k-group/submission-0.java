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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;

        ListNode previousEnd = null;
        ListNode end = null;

        int count;
        while (current != null) {
            previous = null;
            end = current;
            for (count = 0; count < k && current != null; count++) {
                current.next = previous;
                previous = current;
                current = next;
                next = next != null ? next.next : null;
            }

            if (count < k) {
                current = previous;
                next = current.next;
                previous = null;
                end = current;
                while (current != null) {
                    current.next = previous;
                    previous = current;
                    current = next;
                    next = next != null ? next.next : null;
                }
            }

            if (previousEnd != null) {
                previousEnd.next = previous;
            } else {
                head = previous;
            }
            previousEnd = end;
        }

        return head;
    }
}
