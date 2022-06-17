package SortingAlgorithms;

public class BubbleSort 
{
    public void bubblesort(int array[])
    {
        for(int x=0;x<array.length-1;x++)
        {
            for(int y=0;y<array.length-1;y++)
            {
                if(array[y]>array[y+1])
                {
                    int temp=array[y];
                    array[y]=array[y+1];
                    array[y+1]=temp;
                }
            }
            System.out.println();
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
        BubbleSort b=new BubbleSort();
        int array[]={10,5,6,15,16};
        b.bubblesort(array);
        b.print(array);
    }    
}
