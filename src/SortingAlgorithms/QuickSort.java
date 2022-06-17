package SortingAlgorithms;

public class QuickSort
{
    public static int partition(int array[], int start, int end)
    {
        int pivot=end;
        int i=start-1;
        for(int j=start;j<=end;j++)
        {
            if(array[j]<=array[pivot])
            {
                i++;
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        return i;
    }
    public static void quicksort(int array[], int start, int end)
    {
        if(start<end)
        {
            int pivot=partition(array, start, end);
            quicksort(array, start, pivot-1);
            quicksort(array, pivot+1, end);
        }
    }
    public static void print(int array[])
    {
        for(int x=0;x<array.length;x++)
        {
            System.out.print(array[x]+" ");
        }
    }
    public static void main(String args[])
    {
        int array[]={10,3,2,7,7,5,8,4,1,2,9,7,8,11};
        QuickSort.quicksort(array, 0, array.length-1);
        QuickSort.print(array);
    }    
}
