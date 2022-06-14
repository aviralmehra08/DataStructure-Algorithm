import java.util.HashSet;
public class Questions
{
    //deleting duplicates from linked list
    public void deleteDups(LinkedList l)
    {
        HashSet<Integer> hs=new HashSet<>();
        Node current=l.head;
        Node prev=null;
        while(current!=null)
        {
            int curval=current.value;
            if(hs.contains(curval))
            {
                prev.next=current.next;
                l.size--;
            }
            else
            {
                hs.add(curval);
                prev=current;
            }
            current=current.next;
        }
    }
    //Nth to last elemet
    public Node nthtolast(LinkedList l, int n)
    {
        Node p1=l.head;
        Node p2=l.head;
        for(int x=0;x<n;x++)
        {
            if(p2==null) return null;
            p2=p2.next;
        }
        while(p2!=null)
        {
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
    //Partition
    public LinkedList partition(LinkedList l, int x)
    {
        Node currentNode=l.head;
        l.tail=l.head;
        while(currentNode!=null)
        {
            Node next=currentNode.next;
            if(currentNode.value<x)
            {
                currentNode.next=l.head;
                l.head=currentNode;
            }
            else
            {
                l.tail.next=currentNode;
                l.tail=currentNode;
            }
            currentNode=next;
        }
        l.tail.next=null;
        return l;
    }
    //Sum Lists
    public LinkedList sumLists(LinkedList l1, LinkedList l2)
    {
        Node n1=l1.head;
        Node n2=l2.head;
        int carry=0;
        LinkedList resultLL=new LinkedList();
        while(n1!=null || n2!=null)
        {
            int result=carry;
            if(n1!=null)
            {
                result+=n1.value;
                n1=n1.next;
            }
            if(n2!=null)
            {
                result+=n2.value;
                n2=n2.next;
            }
            resultLL.insert(result%10);
            carry=result/10;
        }
        return resultLL;
    }
    //Intersection
    public Node getKthNode(Node head, int k)
    {
        Node current=head;
        while(k>0 && current!=null)
        {
            current=current.next;
            k--;
        }
        return current;
    }
    public Node findIntersection(LinkedList list1, LinkedList list2)
    {
        if(list1.head==null||list2.head==null) return null;
        if(list1.tail!=list2.tail)
        {
            return null;
        }
        Node shorter=new Node();
        Node longer=new Node();
        if(list1.size>list2.size)
        {
            longer=list1.head;
            shorter=list2.head;
        }
        else
        {
            longer=list2.head;
            shorter=list1.head;   
        }
        longer=getKthNode(longer, Math.abs(list1.size-list2.size));
        while(shorter!=longer)
        {
            shorter=shorter.next;
            longer=longer.next;
        }
        return longer;
    }
    public void addSameNode(LinkedList l1, LinkedList l2, int nodevalue)
    {
        Node newnode=new Node();
        newnode.value=nodevalue;
        l1.tail.next=newnode;
        l1.tail=newnode;
        l2.tail.next=newnode;
        l2.tail=newnode;
    }
}
