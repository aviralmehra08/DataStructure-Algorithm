package DoublyLinkedList.Creation;

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
    public static void main(String args[])
    {
        DoublyLinkedList d=new DoublyLinkedList();
        d.creation(1);
        System.out.println(d.head.value);
    }    
}
