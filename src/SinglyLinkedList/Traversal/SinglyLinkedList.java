package SinglyLinkedList.Traversal;

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
    public void traverse()
    {
        if(head==null)
        {
            System.out.println("SLL does not exist");
        }
        else
        {
            Node tempNode=head;
            for(int x=0;x<size;x++)
            {
                System.out.print(tempNode.value);
                if(x!=size-1)
                {
                    System.out.print("->");
                }
                tempNode=tempNode.next;
            }
            System.out.println("\n");
        }
    }
    public static void main(String args[])
    {
        SinglyLinkedList s=new SinglyLinkedList();
        s.creation(5);
        s.insert(6, 1);
        s.insert(7, 3);
        s.insert(8, 4);
        s.insert(9, 5);
        s.traverse();
    }    
}
