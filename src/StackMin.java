public class StackMin 
{
    Node2 top;
    Node2 min;
    public StackMin()
    {
        top=null;
        min=null;
    }
    public int min()
    {
        return min.value;
    }
    public void push(int value)
    {
        if(min==null)
        {
            min=new Node2(value, min);
        }
        else if(min.value<value)
        {
            min=new Node2(min.value, min);
        }
        else
        {
            min=new Node2(value, min);
        }
        top=new Node2(value, top);
    }
    public int pop()
    {
        min=min.next;
        int result=top.value;
        top=top.next;
        return result;
    }
    public static void main(String args[])
    {
        StackMin s=new StackMin();
        s.push(3);
        s.push(2);
        s.push(5);
        s.push(1);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
    }    
}
