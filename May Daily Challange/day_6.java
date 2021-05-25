class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        //base case
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode prev = getPrevOfMid(head);
        ListNode mid = prev.next;
        ListNode next = mid.next;
        prev.next = null;
        TreeNode sol = new TreeNode(mid.val);
        sol.left = sortedListToBST(head);
        sol.right = sortedListToBST(next);

        return sol;
    }
    public ListNode getPrevOfMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
	}

	return prev;
}
}