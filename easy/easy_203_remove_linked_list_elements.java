/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode initHead = head;

        while (head != null) {

            while (head.next != null && head.next.val == val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return initHead;
    }
}