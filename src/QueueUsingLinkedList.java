public class QueueUsingLinkedList 
{
    SinglyLinkedList list;
    public QueueUsingLinkedList()
    {
        list=new SinglyLinkedList();
        System.out.println("Successfully Created");
    }
    //isEmpty
    public boolean isEmpty()
    {
        if(list.head==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //enqueue
    public void enqueue(int value)
    {
        list.insert(value, list.size);
        System.out.println("Inserted "+value);

    }
    //dequeue
    public int dequeue()
    {
        int value=-1;
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return value;
        }
        else
        {
            value=list.head.value;
            list.delete(0);
        }
        return value;
    }
    //peek
    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return -1;
        }
        else
        {
            return list.head.value;
        }
    }
    //delete
    public void delete()
    {
        list.head=null;
        list.tail=null;
        System.out.println("Successfully Deleted");
    }
    public static void main(String args[])
    {
        QueueUsingLinkedList q=new QueueUsingLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        boolean result=q.isEmpty();
        System.out.println(result);
        int r=q.dequeue();
        System.out.println(r);
    }    
}
