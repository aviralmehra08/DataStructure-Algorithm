package SortingAlgorithms;

public class MergeSort
{
    public static void merge(int A[], int left, int middle, int right)
    {
        int lefttmparray[]=new int[middle-left+2];
        int righttmparray[]=new int[right-middle+1];
        for(int x=0;x<=middle-left;x++)
        {
            lefttmparray[x]=A[left+x];
        }
        for(int x=0;x<right-middle;x++)
        {
            righttmparray[x]=A[middle+1+x];
        }
        lefttmparray[middle-left+1]=Integer.MAX_VALUE;
        righttmparray[right-middle]=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        for(int k=left;k<=right;k++)
        {
            if(lefttmparray[i]<righttmparray[j])
            {
                A[k]=lefttmparray[i];
                i++;
            }
            else
            {
                A[k]=righttmparray[j];
                j++;
            }
        }
    }
    public static void mergesort(int Array[], int left, int right)
    {
        if(right>left)
        {
            int m=(left+right)/2;
            mergesort(Array, left, m);
            mergesort(Array, m+1, right);
            merge(Array, left, m, right);
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
        int array[]={10,3,2,5,8,4,3,1,2,9,7,8};
        MergeSort.mergesort(array,0,array.length-1);
        MergeSort.print(array);
    }    
}
