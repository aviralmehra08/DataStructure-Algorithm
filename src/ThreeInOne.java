public class ThreeInOne 
{
    private int numberofstacks=3;
    private int stackcapacity;
    private int values[];
    private int size[];
    public ThreeInOne(int stackSize)
    {
        stackcapacity=stackSize;
        values=new int[stackSize*numberofstacks];
        size=new int[numberofstacks];
    }
    public boolean isFull(int stackNum)
    {
        if(size[stackNum]==stackcapacity)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isEmpty(int stackNum)
    {
        if(size[stackNum]==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private int indexOfTop(int stackNum)
    {
        int offset=stackNum*stackcapacity;
        int sizes=size[stackNum];
        return offset+sizes-1;
    }
    public void push(int stackNum, int value)
    {
        if(isFull(stackNum))
        {
            System.out.println("Stack is full");
        }
        else
        {
            size[stackNum]++;
            values[indexOfTop(stackNum)]=value;
        }
    }
    public int pop(int stackNum)
    {
        if(isEmpty(stackNum))
        {
            System.out.println("Stack is empty");
            return -1;
        }
        else
        {
            int topIndex=indexOfTop(stackNum);
            int value=values[topIndex];
            values[topIndex]=0;
            size[stackNum]--;
            return value;
        }
    }
    public int peek(int stackNum)
    {
        if(isEmpty(stackNum))
        {
            System.out.println("Stack is empty");
            return -1;
        }
        else
        {
            return values[indexOfTop(stackNum)];
        }  
    }
    public static void main(String args[])
    {
        ThreeInOne t=new ThreeInOne(3);
        t.push(0, 1);
        t.push(0, 2);
        t.push(1, 4);
        t.push(1, 5);
        t.push(2, 8);
        int result=t.pop(2);
        System.out.println(result);
        int result1=t.peek(2);
        System.out.println(result1);
    }
}
