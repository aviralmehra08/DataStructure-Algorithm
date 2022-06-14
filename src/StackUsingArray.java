public class StackUsingArray
{
    int array[];
    int topofstack;
    public StackUsingArray(int size)
    {
        this.array=new int[size];
        topofstack=-1;
        System.out.println("The stack is created of size "+size);
    }
    //isEmpy
    public boolean isEmpy()
    {
        if(topofstack==-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //isFull
    public boolean isFull()
    {
        if(topofstack==array.length-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    } 
    //Push
    public void push(int value)
    {
        if(isFull())
        {
            System.out.println("The stack is full");
        }
        else
        {
            array[topofstack+1]=value;
            topofstack++;
            System.out.println("Value has been inserted succesfully");
        }
    }
    //Pop
    public int pop()
    {
        if(isEmpy())
        {
            System.out.println("Stack is Empty");
            return -1;
        }
        else
        {
            int top=array[topofstack];
            topofstack--;
            return top;
        }
    }
    //Peek
    public int peek()
    {
        if(isEmpy())
        {
            System.out.println("Stack is Empty");
            return -1;
        }
        else
        {
            return array[topofstack];
        }
    }
    //deletestack
    public void delete()
    {
        array=null;
        System.out.println("Stack is deleted");
    }  
    public static void main(String args[])
    {
        StackUsingArray s=new StackUsingArray(4);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        int result=s.pop();
        System.out.println(result);
        int result1=s.peek();
        System.out.println(result1);
    }
}
