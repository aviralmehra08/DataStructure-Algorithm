package DoublyLinkedList.Search;

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
            System.out.println("\n");
        }
        else
        {
            System.out.println("DLL does not exist");
        }
    }
    public void reversetravseral()
    {
        if(head!=null)
        {
            DoublyNode tempNode=tail;
            for(int x=0;x<size;x++)
            {
                System.out.print(tempNode.value);
                if(x!=size-1)
                {
                    System.out.print("->");
                }
                tempNode=tempNode.prev;
            }
            System.out.println("\n");
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
                    System.out.println("Node at location "+x);
                    return true;
                }
                tempNode=tempNode.next;
            }
            System.out.println("\n");
        }
        System.out.println("Node not found");
        return false;
    }
    public static void main(String args[])
    {
        DoublyLinkedList d=new DoublyLinkedList();
        d.creation(1);
        d.insert(2, 1);
        d.insert(3, 2);
        d.traverse();
        d.reversetravseral();
        d.search(2);
    }    
}

