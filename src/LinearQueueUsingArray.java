public class LinearQueueUsingArray
{
    int array[];
    int beginningOfQueue;
    int topOfQueue;
    public LinearQueueUsingArray(int size)
    {
        this.array=new int[size];
        this.topOfQueue=-1;
        this.beginningOfQueue=-1;
        System.out.println("Successfuly Created of size "+size);
    }
    //isFull
    public boolean isFull()
    {
        if(topOfQueue==array.length-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //isEmpty
    public boolean isEmpty()
    {
        if(beginningOfQueue==-1 || beginningOfQueue==array.length-1)
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
            System.out.println("Queue is full");
            return;
        }
        else if(isEmpty())
        {
            beginningOfQueue=0;
            topOfQueue++;
            array[topOfQueue]=value;
            System.out.println("Inserted value");
        }
        else
        {
            topOfQueue++;
            array[topOfQueue]=value;
            System.out.println("Inserted value");
        }
    }
    //dequeue
    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue Empty");
            return -1;
        }
        else
        {
            int result=array[beginningOfQueue];
            beginningOfQueue++;
            if(beginningOfQueue>topOfQueue)
            {
                beginningOfQueue=-1;
                topOfQueue=-1;
            }
            return result;
        }
    }
    //peek
    public int peek()
    {
        if(!isEmpty())
        {
            return array[beginningOfQueue];
        }
        else
        {
            return -1;
        }
    }
    //delete entire queue
    public void delete()
    {
        array=null;
        System.out.println("Deleted Queue");
    }
    public static void main(String args[])
    {
        LinearQueueUsingArray l=new LinearQueueUsingArray(3);
        l.enQueue(1);
        l.enQueue(2);
        l.enQueue(3);
        int result=l.dequeue();
        System.out.println(result);
    }    
}
