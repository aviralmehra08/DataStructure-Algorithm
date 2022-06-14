package CircularDoublyLinkedList.Search;
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
    public void traverse()
    {
        if(head!=null)
        {
            DoublyNode tempNode=head;
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
            System.out.println("CDLL does not exist");
        }
    }
    public void reverse()
    {
        if(head!=null)
        {
            DoublyNode tempNode=tail;
            for(int x=0;x<size;x++)
            {
                System.out.print(tempNode.value);
                if(x!=size-1)
                {
                    System.out.print("<-");
                }
                tempNode=tempNode.prev;
            }
        }
    }
    public boolean search(int nodevalue)
    {
        if(head!=null)
        {
            DoublyNode tempNode=head;
            for(int x=0;x<size;x++)
            {
                if(tempNode.value==nodevalue)
                {
                    System.out.println("Found at index "+x);
                    return true;
                }
                tempNode=tempNode.next;
            }
        }
        System.out.println("Node does not exist");
        return false;
    }
    public static void main(String args[])
    {
        CircularDoublyLinkedList cl=new CircularDoublyLinkedList();
        cl.creation(1);
        cl.insert(2, 1);
        cl.insert(3, 2);
        cl.traverse();
        cl.reverse();
    } 
}