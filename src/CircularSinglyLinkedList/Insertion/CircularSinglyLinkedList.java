package CircularSinglyLinkedList.Insertion;
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
    public void insert(int nodevalue,int location)
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
            tail.next=head;
        }
        else if(location>=size)
        {
            tail.next=node;
            tail=node;
            tail.next=head;
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
            node.next=tempNode.next;
            tempNode.next=node;
        }
        size++;
    }
    public static void main(String args[])
    {
        CircularSinglyLinkedList c=new CircularSinglyLinkedList();
        c.creation(10);
        c.insert(4, 0);
        c.insert(4, 1);
        c.insert(4, 8);
        System.out.println(c.head.value);
    }    
}
