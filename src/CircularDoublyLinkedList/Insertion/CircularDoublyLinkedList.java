package CircularDoublyLinkedList.Insertion;

public class CircularDoublyLinkedList
{
    public DoublyNode head;
    public DoublyNode tail;
    int size;
    public DoublyNode creation(int nodevalue)
    {
        head=new DoublyNode();
        DoublyNode newnode=new DoublyNode();
        newnode.value=nodevalue;
        head=newnode;
        tail=newnode;
        newnode.prev=newnode;
        newnode.next=newnode;
        size=1;
        return head;
    }
    public void insert(int nodevalue, int location)
    {
        DoublyNode newnode=new DoublyNode();
        newnode.value=nodevalue;
        if(head==null)
        {
            creation(nodevalue);
            return;
        }
        else if(location==0)
        {
            newnode.next=head;
            newnode.prev=tail;
            head.prev=newnode;
            tail.next=newnode;
            head=newnode;
        }
        else if(location>=size)
        {
            newnode.next=head;
            newnode.prev=tail;
            head.prev=newnode;
            tail.next=newnode;
            tail=newnode;
        }
        else
        {
            DoublyNode tempNode=head;
            int index=0;
            while(index<location-1)
            {
                tempNode=tempNode.next;
                index++;
            }
            newnode.next=tempNode.next;
            newnode.prev=tempNode;
            tempNode.next=newnode;
            newnode.next.prev=newnode;
        }
        size++;
    }
    public static void main(String args[])
    {
        CircularDoublyLinkedList cl=new CircularDoublyLinkedList();
        cl.creation(1);
        cl.insert(2, 1);
        System.out.println(cl.head.next.value);
    }    
}
