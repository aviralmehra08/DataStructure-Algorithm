package SortingAlgorithms;

public class SelectionSort
{
    public void selectionsort(int array[])
    {
        for(int x=0;x<array.length;x++)
        {
            int minimumIndex=x;
            for(int y=x+1;y<array.length;y++)
            {
                if(array[y]<array[minimumIndex])
                {
                    minimumIndex=y;
                }
            }
            if(minimumIndex!=x)
            {
                int temp=array[x];
                array[x]=array[minimumIndex];
                array[minimumIndex]=temp;
            }
        }
    }
    public void print(int array[])
    {
        for(int x=0;x<array.length;x++)
        {
            System.out.print(array[x]+" ");
        }
    }
    public static void main(String args[])
    {
        SelectionSort s=new SelectionSort();
        int array[]={10,5,2,6,20};
        s.selectionsort(array);
        s.print(array);
    }    
}
