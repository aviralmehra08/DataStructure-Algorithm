package SearchingAlgorithms;

public class BinarySearch
{
    public static int binaryearch(int array[],int value)
    {
        int start=0;
        int end=array.length-1;
        int middle=(start+end)/2;
        System.out.println(start+" "+middle+" "+end);
        while(array[middle]!=value && start<=end)
        {
            if(value<array[middle])
            {
                end=middle-1;
            }
            else
            {
                start=middle+1;
            }
            middle=(start+end)/2;
        }
        if(array[middle]==value)
        {
            System.out.println("The element is found at index "+middle);
            return middle;
        }
        else
        {
            System.out.println("Value not found");
            return -1;
        }
    }
    public static void main(String args[])
    {
        int array[]={8,9,12,15,17,19,20,21,28};
        BinarySearch.binaryearch(array, 15);
    }
}
