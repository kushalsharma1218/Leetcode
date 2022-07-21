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
    public ListNode reverseBetween(ListNode head, int l, int r) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode left = dummy;
        ListNode prev = null;
        
        for(int i = 0;i<l;i++)
        {
            prev = left;
            left = left.next;
        }
        
        ListNode curr = left;
        ListNode prevNode = prev;
        
        for(int i = l;i<=r;i++)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        left.next = curr;
        prevNode.next = prev;
        
        return dummy.next;
    }
}