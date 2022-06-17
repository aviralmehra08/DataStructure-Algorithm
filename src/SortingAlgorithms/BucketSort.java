package SortingAlgorithms;
import java.util.ArrayList;
import java.util.Collections;
public class BucketSort
{
    int array[];
    public BucketSort(int array[])
    {
        this.array=array;
    }
    //print buckets
    public void printBucket(ArrayList<Integer>[] buckets)
    {
        for(int x=0;x<buckets.length;x++)
        {
            System.out.println("\nBucket"+x+":");
            for(int y=0;y<buckets[x].size();y++)
            {
                System.out.print(buckets[x].get(y)+" ");
            }
        }
    }
    //Bucket Sorting
    public void bucketsort()
    {
        int numberofbuckets=(int)Math.ceil(Math.sqrt(array.length));
        int maxvalue=Integer.MIN_VALUE;
        for(int value: array)
        {
            if(value>maxvalue)
            {
                maxvalue=value;
            }
        }
        ArrayList<Integer>[] buckets=new ArrayList[numberofbuckets];
        for(int x=0;x<buckets.length;x++)
        {
            buckets[x]=new ArrayList<Integer>();
        }
        for(int value: array)
        {
            int bucketnumber=(int)Math.ceil(((float)value*numberofbuckets)/(float)maxvalue);
            buckets[bucketnumber-1].add(value);
        }
        System.out.println("Printing buckets before sorting..");
        printBucket(buckets);
        for(ArrayList<Integer> bucket:buckets)
        {
            Collections.sort(bucket);
        }
        System.out.println("Printing buckets after sorting..");
        printBucket(buckets);
        int index=0;
        for(ArrayList<Integer> bucket: buckets)
        {
            for(int value:bucket)
            {
                array[index]=value;
                index++;
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
        int array[]={9,7,5,4,2,1,3,6,8};
        BucketSort b=new BucketSort(array);
        b.bucketsort();
        b.print(array);
    }
}
