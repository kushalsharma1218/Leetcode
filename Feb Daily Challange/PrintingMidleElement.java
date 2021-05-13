class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode temp=head;
        ListNode temp1=head;
        
        if(head==null)
        {
            return head;
        }
        if(head.next==null)
        {
            return head;
        }
        while(temp1.next!=null && temp1.next.next!=null)
        {
            temp=temp.next;
            temp1=temp1.next.next;
          
        }
        if(temp1.next==null)
        return temp;
        else
            return temp.next;
    }
}