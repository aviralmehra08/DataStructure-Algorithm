package SinglyLinkedList.Insertion;

public class SinglyLinkedList
{
    public Node head;
    public Node tail;
    public int size;
    public Node creation(int nodevalue)
    {
        head=new Node();
        Node node=new Node();
        node.next=null;
        node.value=nodevalue;
        head=node;
        tail=node;
        size=1;
        return head;
    }
    public void insert(int nodevalue, int location)
    {
        Node node=new Node();
        node.value=nodevalue;
        if(head==null)
        {
            creation(nodevalue);
            return;
        }
        else if(location==0)
        {
            node.next=head;
            head=node;
        }
        else if(location>=size)
        {
            node.next=null;
            tail.next=node;
            tail=node;
        }
        else
        {
            Node tempNode=head;
            int index=0;
            while(index<location-1)
            {
                tempNode=tempNode.next;
                index++;
            }
            Node nextNode=tempNode.next;
            tempNode.next=node;
            node.next=nextNode; 
        }
        size++;
    }
    public static void main(String args[])
    {
        SinglyLinkedList sll=new SinglyLinkedList();
        sll.creation(5);
        System.out.println(sll.head.value);
        sll.insert(10, 0);
        System.out.println(sll.head.value);
    }
}
