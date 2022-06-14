package CircularSinglyLinkedList.Deletion;

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
    public void traverse()
    {
        if(head!=null)
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
        }
        else
        {
            System.out.println("CLL does not exist");
        }
    }
    public boolean search(int nodevalue)
    {
        if(head!=null)
        {
            Node tempNode=head;
            for(int x=0;x<size;x++)
            {
                if(tempNode.value==nodevalue)
                {
                    System.out.println("Found at node location "+x);
                    return true;
                }
                tempNode=tempNode.next;
            }
        }
        System.out.println("Node does not exist");
        return false;
    }
    public void delete(int location)
    {
        if(head==null)
        {
            System.out.println("CSLL does not exist");
            return;
        }
        else if(location==0)
        {
            head=head.next;
            tail.next=head;
            size--;
            if(size==0)
            {
                tail=head=null;
                head.next=null;
            }
        }
        else if(location>=size)
        {
            Node tempNode=head;
            for(int x=0;x<size-1;x++)
            {
                tempNode=tempNode.next;
            }
            if(tempNode==head)
            {
                head.next=null;
                tail=head=null;
                size--;
                return;
            }
            tempNode.next=head;
            tail=tempNode;
            size--;
        }
        else
        {
            Node tempNode=head;
            for(int x=0;x<location-1;x++)
            {
                tempNode=tempNode.next;
            }
            tempNode.next=tempNode.next.next;
            size--;
        }
    }
    public static void main(String args[])
    {
        CircularSinglyLinkedList c=new CircularSinglyLinkedList();
        c.creation(5);
        c.insert(4, 0);
        c.insert(6, 1);
        c.insert(7, 8);
        c.traverse();
        c.search(5);
        c.delete(2);
        c.traverse();
    }    
}

