package CircularSinglyLinkedList.Creation;

public class CircularSinglyLinkedList
{
    public Node head;
    public Node tail;
    int size;
    public Node creation(int nodevalue)
    {
        head=new Node();
        Node node=new Node();
        node.next=node;
        node.value=nodevalue;
        head=node;
        tail=node;
        size=1;
        return head;
    }
    public static void main(String args[])
    {
        CircularSinglyLinkedList c=new CircularSinglyLinkedList();
        c.creation(10);
        System.out.println(c.head.value);
        System.out.println(c.head.value);
    }
}
