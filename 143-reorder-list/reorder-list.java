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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)return;
        // Reach the middle pointer using slow and fast pointer
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast=fast.next.next;
        }
        ListNode rightHalfReversed = reverse(slow.next);
        slow.next=null;  // Get the left node only
        ListNode leftHalf = head;
        merge(leftHalf,rightHalfReversed);
    }

    private ListNode reverse(ListNode head) {
        if(head == null)return null;
        ListNode prev= null;
        ListNode curr = head; 
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private void merge(ListNode list1,ListNode list2) {
        while(list2 != null) {
            ListNode temp = list1.next;
            list1.next = list2;
            list1=list2;
            list2 = temp;
        }
    }
}