public class LinkedList
{
    public Node head;
    public Node tail;
    int size;
    public Node creation(int nodevalue)
    {
        head=new Node();
        Node newnode=new Node();
        newnode.next=null;
        newnode.value=nodevalue;
        head=newnode;
        tail=newnode;
        size=1;
        return head;
    }
    public void insert(int nodevalue)
    {
        if(head==null)
        {
            creation(nodevalue);
            return;
        }
        Node newnode=new Node();
        newnode.value=nodevalue;
        newnode.next=null;
        tail.next=newnode;
        tail=newnode;
        size++;
    }
    public void traversal()
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
    public static void main(String args[])
    {
        LinkedList l1=new LinkedList();
        l1.creation(1);
        l1.insert(2);
        l1.insert(3);
        l1.insert(2);
        l1.insert(4);
        l1.traversal();
        LinkedList l2=new LinkedList();
        l2.creation(1);
        l2.insert(2);
        l2.insert(3);
        l2.insert(2);
        l2.insert(4);
        l2.traversal();
        Questions q=new Questions();
        q.deleteDups(l1);
        l1.traversal();
        Node n=q.nthtolast(l1, 2);
        System.out.println(n.value);
        LinkedList t=q.partition(l1, 4);
        t.traversal();
        LinkedList result=q.sumLists(l1, l2);
        result.traversal();
        q.addSameNode(l1, l2, 7);
        q.addSameNode(l1, l2, 2);
        q.addSameNode(l1, l2, 1);
        Node inter=q.findIntersection(l1, l2);
        System.out.println(inter.value);
    }    
}
