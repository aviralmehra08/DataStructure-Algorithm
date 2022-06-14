package CircularDoublyLinkedList.Creation;

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
    public static void main(String[] args)
    {
        CircularDoublyLinkedList c=new CircularDoublyLinkedList();
        c.creation(5);
        System.out.println(c.head.value);    
    }    
}
