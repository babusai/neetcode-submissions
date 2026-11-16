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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode first = list1;
        ListNode second = list2;

        ListNode result = null;
        ListNode next = null;
        ListNode node = null;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                next = first.next;
                first.next = null;
                if (result == null) {
                    result = first;
                    node = first;
                } else {
                    node.next = first;
                    node = node.next;
                }
                first = next;
            } else {
                next = second.next;
                second.next = null;
                if (result == null) {
                    result = second;
                    node = second;
                } else {
                    node.next = second;
                    node = node.next;
                }
                second = next;
            }
        }

        if (first != null) {
            node.next = first;
        } else if (second != null) {
            node.next = second;
        }

        return result;
    }
}