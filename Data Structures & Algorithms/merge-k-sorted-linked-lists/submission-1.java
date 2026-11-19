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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode[] mergedLists;
        int index;
        int mergedListsIndex;
        while (lists.length != 1) {
            index = 0;
            mergedListsIndex = 0;
            mergedLists =
                new ListNode[lists.length % 2 == 0 ? lists.length / 2
                                                   : (int) Math.floor((lists.length / 2) + 1)];
            while (index + 1 < lists.length) {
                mergedLists[mergedListsIndex] = merge(lists[index], lists[index + 1]);
                index += 2;
                mergedListsIndex++;
            }
            if (index == lists.length - 1) {
                mergedLists[mergedListsIndex] = lists[index];
            }
            lists = mergedLists;
        }

        return lists[0];
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode mergedHead = null;
        ListNode node = null;
        while (first != null && second != null) {
            if (second.val < first.val) {
                if (node != null) {
                    node.next = second;
                    second = second.next;
                    node = node.next;
                } else {
                    node = second;
                    mergedHead = node;
                    second = second.next;
                }
            } else {
                if (node != null) {
                    node.next = first;
                    first = first.next;
                    node = node.next;
                } else {
                    node = first;
                    mergedHead = node;
                    first = first.next;
                }
            }
        }

        if (second != null) {
            if (mergedHead == null) {
                mergedHead = second;
            } else {
                node.next = second;
            }
        } else if (first != null) {
            if (mergedHead == null) {
                mergedHead = first;
            } else {
                node.next = first;
            }
        }

        return mergedHead;
    }
}
