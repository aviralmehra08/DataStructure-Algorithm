package Tree.BinaryHeap;

public class BinaryHeap
{
    int array[];
    int sizeoftree;
    public BinaryHeap(int size)
    {
        array=new int[size+1];
        this.sizeoftree=0;
        System.out.println("Binary Heap has been created");
    }
    public boolean isEmpty()
    {
        if(sizeoftree==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Integer peek()
    {
        if(isEmpty())
        {
            System.out.println("Binary Heap is empty");
            return null;
        }
        return array[1];
    }
    public int sizeofBP()
    {
        return sizeoftree;
    }
    public void levelorder()
    {
        for(int x=1;x<=sizeoftree;x++)
        {
            System.out.println(array[x]+" ");
        }
        System.out.println("\n");
    }
    public void heapifyBottomToTop(int index, String heapType)
    {
        int parent=index/2;
        if(index<=2)
        {
            return;
        }
        if(heapType=="Min")
        {
            if(array[index]<array[parent])
            {
                int tmp=array[index];
                array[index]=array[parent];
                array[parent]=tmp;
            }
        }
        else if(heapType=="Max")
        {
            if(array[index]>array[parent])
            {
                int tmp=array[index];
                array[index]=array[parent];
                array[parent]=tmp;
            }
        }
        heapifyBottomToTop(parent, heapType);
    }
    public void insert(int value,String typeHeap)
    {
        array[sizeoftree+1]=value;
        sizeoftree++;
        heapifyBottomToTop(sizeoftree, typeHeap);
    }
    public static void main(String args[])
    {
        BinaryHeap b=new BinaryHeap(5);
        b.insert(10, "Max");
        b.insert(5, "Max");
        b.insert(15, "Max");
        b.insert(1, "Max");
        b.peek();
    }    
}
