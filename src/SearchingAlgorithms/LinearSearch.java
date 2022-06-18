package SearchingAlgorithms;
public class LinearSearch
{
    public int linearsearch(int array[], int value)
    {
        for(int x=0;x<array.length;x++)
        {
            if(array[x]==value)
            {
                System.out.println("Element found at index "+x);
                return x;
            }
        }
        System.out.println("Value not found");
        return -1;
    }
    public static void main(String args[])
    {
        LinearSearch l=new LinearSearch();
        int array[]={1,2,3,10,15,20};
        l.linearsearch(array, 15);
    }
}