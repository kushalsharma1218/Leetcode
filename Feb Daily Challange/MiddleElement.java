import java.io.*;
class Node<E>
{
	E data;
	Node next;
	
	public Node(E data)
	{
		this.data=data;
		this.next=null;
		
	}
}
class LinkedList<E>
{
	Node<E> head;
	
	void inserAtBeg(E data)
	{
		Node<E> newNode=new Node<>(data);
		
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			newNode.next=head;
			head=newNode;
		}
	}
	
	public void getMiddlelement()
	{
		Node mid=head;
		Node temp=head;
		int count=0;
		while(temp!=null)
		{
			if(count%2!=0)mid=mid.next;
			
			count++;
			temp=temp.next;
		}
		System.out.println("Middle element = "+mid.data);
	}
	void print()
	{
		Node<E> temp=head;
			while(temp!=null)
			{
				System.out.println(temp.data);
				temp=temp.next;
			}
			
	}
	
}
class A
{
	public static void main(String ar[]){
		
		LinkedList<Integer> list=new LinkedList<>();
		
		list.inserAtBeg(6);
		list.inserAtBeg(5);
		list.inserAtBeg(4);
		list.inserAtBeg(3);
		list.inserAtBeg(2);
		list.inserAtBeg(1);
		list.inserAtBeg(1);
		list.inserAtBeg(1);
		list.inserAtBeg(1);
		list.getMiddlelement();
		list.print();
}
}