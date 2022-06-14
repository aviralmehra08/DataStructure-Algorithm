public class StackUsingLinkedList
{
    SinglyLinkedList s;
    public StackUsingLinkedList()
    {
        s=new SinglyLinkedList();
    }
    //Push
    public void push(int nodevalue)
    {
        s.insert(nodevalue, 0);
        System.out.println("Inserted "+nodevalue+" in stack");
    }
    //isEmpty
    public boolean isEmpty()
    {
        if(s.head==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //Pop
    public int pop()
    {
        int result=-1;
        if(isEmpty())
        {
            System.out.println("Stack is Empty");
            return result;
        }
        else
        {
            result=s.head.value;
            s.delete(0);
        }
        return result;
    }
    //Peek
    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty");
            return -1;
        }
        else
        {
            return s.head.value;
        }
    }
    //delete
    public void delete()
    {
        s.head=null;
        System.out.println("Stack is deleted");
    }
    public static void main(String args[])
    {
        StackUsingLinkedList s=new StackUsingLinkedList();
        s.push(1);
        s.push(2);
        boolean result=s.isEmpty();
        System.out.println(result);
        int result2=s.pop();
        System.out.println(result2);
        s.peek();
    }
}
