package DivideAndConquerAlgorithms;
public class NumberFactor
{
    public int waystogetN(int n)
    {
        if((n==0)||(n==1)||(n==2))
        {
            return 1;
        }
        if(n==3)
        {
            return 2;
        }
        int sub1=waystogetN(n-1);
        int sub2=waystogetN(n-3);
        int sub3=waystogetN(n-4);
        return sub1+sub2+sub3;
    }
    public static void main(String args[])
    {
        NumberFactor n=new NumberFactor();
        System.out.println(n.waystogetN(4));
        System.out.println(n.waystogetN(5));
        System.out.println(n.waystogetN(6));
    }
}