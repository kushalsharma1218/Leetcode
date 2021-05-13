
class GFG {
    Node Delete(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        
        Node temp=head;
        Node fast=head;
        int count=0;
        while(fast!=null)
        {
            count++;
            fast=fast.next;
        }
        Node slow=head;
        int mid=0;
        if(count%2==0)
        {
            mid=count/2;
            for(int i=0;i<mid-1;i++)
        {
            slow=slow.next;
            
        }
        slow.next=slow.next.next;
        }
        else
        {
            mid=(count/2)+1;
        for(int i=1;i<mid-1;i++)
        {
            slow=slow.next;
            
        }
        slow.next=slow.next.next;
        }
        
    
        return head;
        
    }
}