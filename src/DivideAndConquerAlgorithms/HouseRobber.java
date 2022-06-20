package DivideAndConquerAlgorithms;

public class HouseRobber
{
    public int maxMoneyRecursive(int HouseNetWorth[], int currentIndex)
    {
        if(currentIndex>=HouseNetWorth.length)
        {
            return 0;
        }
        int stealCurrentHouse=HouseNetWorth[currentIndex]+maxMoneyRecursive(HouseNetWorth, currentIndex+2);
        int skipCurrentHouse=maxMoneyRecursive(HouseNetWorth, currentIndex+1);
        return Math.max(stealCurrentHouse,skipCurrentHouse);
    }
    public int maxMoney(int HouseNetWorth[])
    {
        return maxMoneyRecursive(HouseNetWorth, 0);
    }    
    public static void main(String args[])
    {
        HouseRobber h=new HouseRobber();
        int HouseNetWorth[]={6,7,1,30,8,2,4};
        System.out.println(h.maxMoney(HouseNetWorth));
    }
}
