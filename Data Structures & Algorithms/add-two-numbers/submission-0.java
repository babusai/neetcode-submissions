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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode node = null;

        int carry = 0;
        int sum;

        int first;
        int second;

        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;

                if (node != null) {
                    l1.val = sum % 10;
                    node.next = l1;
                    node = node.next;
                    l1 = l1.next;
                    l2 = l2.next;
                    node.next = null;
                } else {
                    l1.val = sum % 10;
                    node = l1;
                    head = node;
                    l1 = l1.next;
                    l2 = l2.next;
                    node.next = null;
                }
            } else if (l1 != null) {
                sum = l1.val + carry;
                l1.val = sum % 10;
                node.next = l1;
                node = node.next;
                l1 = l1.next;
                node.next = null;
            } else if (l2 != null) {
                sum = l2.val + carry;
                l2.val = sum % 10;
                node.next = l2;
                node = node.next;
                l2 = l2.next;
                node.next = null;
            } else {
                sum = carry;
                node.next = new ListNode(carry);
            }

            carry = sum / 10;
        }

        return head;
    }
}
