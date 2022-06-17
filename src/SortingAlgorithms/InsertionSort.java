package SortingAlgorithms;

public class InsertionSort
{
    public void insertion(int array[])
    {
        for(int x=1;x<array.length;x++)
        {
            int current=array[x];
            int y=x;
            while(y>0 && array[y-1]>current)
            {
                array[y]=array[y-1];
                y--;
            }
            array[y]=current;
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
        InsertionSort i=new InsertionSort();
        int array[]={10,5,6,2,20};
        i.insertion(array);
        i.print(array);
    }   
}
