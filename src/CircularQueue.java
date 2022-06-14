public class CircularQueue
{
    int array[];
    int topOfQueue;
    int beginningOfQueue;
    int size;
    public CircularQueue(int size)
    {
        this.array=new int[size];
        this.size=size;
        this.topOfQueue=-1;
        this.beginningOfQueue=-1;
        System.out.println("created using size of "+size);
    }
    //isEmpty
    public boolean isEmpty()
    {
        if(topOfQueue==-1)
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
        if(topOfQueue+1==beginningOfQueue)
        {
            return true;
        }
        else if(beginningOfQueue==0 && topOfQueue+1==size)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //Enqueue
    public void enQueue(int value)
    {
        if(isFull())
        {
            System.out.println("CQ is full");
            return;
        }
        else if(isEmpty())
        {
            beginningOfQueue=0;
            topOfQueue++;
            array[topOfQueue]=value;
            System.out.println("Inserted" +value);
        }
        else
        {
            if(topOfQueue+1==size)
            {
                topOfQueue=0;
            }
            else
            {
                topOfQueue++;
            }
            array[topOfQueue]=value;
            System.out.println("Inserted "+value);
        }
    }
    //dequeue
    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("CDQ is empty");
            return -1;
        }
        else
        {
            int result=array[beginningOfQueue];
            array[beginningOfQueue]=0;
            if(beginningOfQueue==topOfQueue)
            {
                beginningOfQueue=topOfQueue=-1;
            }
            else if(beginningOfQueue+1==size)
            {
                beginningOfQueue=0;
            }
            else
            {
                beginningOfQueue++;
            }
            return result;
        }
    }
    //peek
    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("CQ is empty");
            return -1;
        }
        else
        {
            return array[beginningOfQueue];
        }
    }
    //delete entire dequeue
    public void delete()
    {
        array=null;
        System.out.println("Deleted");
    }
    public static void main(String args[])
    {
        CircularQueue c=new CircularQueue(3);
        c.enQueue(1);
        c.enQueue(2);
    }    
}
