package SinglyLinkedList.Creation;

public class SinglyLinkedList
{
    public Node head;
    public Node tail;
    public int size;
    public Node creationSinglyLinkedList(int nodeValue)
    {
        head=new Node();
        Node node=new Node();
        node.next=null;
        node.value=nodeValue;
        head=node;
        tail=node;
        size=1;
        return head;
    }
    public static void main(String args[])
    {
        SinglyLinkedList sll=new SinglyLinkedList();
        sll.creationSinglyLinkedList(10);
        System.out.println(sll.head.value);
    }    
}
