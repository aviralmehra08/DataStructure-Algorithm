package DoublyLinkedList.Insertion;

public class DoublyLinkedList
{
    DoublyNode head;
    DoublyNode tail;
    int size;
    public DoublyNode creation(int nodevalue)
    {
        head=new DoublyNode();
        DoublyNode newnode=new DoublyNode();
        newnode.value=nodevalue;
        newnode.next=null;
        newnode.prev=null;
        head=newnode;
        tail=newnode;
        size=1;
        return head;
    }
    public void insert(int nodevalue, int location)
    {
        DoublyNode newNode=new DoublyNode();
        newNode.value=nodevalue;
        if(head==null)
        {
            creation(nodevalue);
            return;
        }
        else if(location==0)
        {
            newNode.next=head;
            newNode.prev=null;
            head.prev=newNode;
            head=newNode;
        }
        else if(location>=size)
        {
            newNode.next=null;
            newNode.prev=tail;
            tail.next=newNode;
            tail=newNode;
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
            newNode.prev=tempNode;
            newNode.next=tempNode.next;
            tempNode.next=newNode;
            newNode.next.prev=newNode;
        }
        size++;
    }
    public static void main(String args[])
    {
        DoublyLinkedList d=new DoublyLinkedList();
        d.creation(1);
        d.insert(2, 1);
    }    
}
