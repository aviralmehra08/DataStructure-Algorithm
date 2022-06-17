package Hashing;
import java.util.LinkedList;
public class DirectChaining
{
    LinkedList<String>[] hashtable;
    int maxChainSize=5;
    public DirectChaining(int size)
    {
        hashtable=new  LinkedList[size];
    }
    public int modASCIIHashFunction(String word, int M)
    {
        char ch[];
        ch=word.toCharArray();
        int sum,i;
        for(sum=0,i=0;i<word.length();i++)
        {
            sum=sum+ch[i];
        }
        return sum%M;
    }
    public void insertHashTable(String word)
    {
        int newindex=modASCIIHashFunction(word, hashtable.length);
        if(hashtable[newindex]==null)
        {
            hashtable[newindex]=new LinkedList<String>();
            hashtable[newindex].add(word);
        }
        else
        {
            hashtable[newindex].add(word);
        }
    }
    public void display()
    {
        if(hashtable==null)
        {
            System.out.println("Hash table does not exits");
            return;
        }
        else
        {
            for(int x=0;x<hashtable.length;x++)
            {
                System.out.println("Index "+x+" key :"+ hashtable[x]);
            }
        }
    }
    public boolean searchHashTable(String word)
    {
        int newindex=modASCIIHashFunction(word, hashtable.length);
        if(hashtable[newindex]!=null && hashtable[newindex].contains(word))
        {
            System.out.println("\n"+"\""+word+"\"" + " found in table at location: "+newindex);
            return true;
        }
        else
        {
            System.out.println("\n"+"\""+word+"\"" + " not found in table");
            return false;
        }
    }
    public void delete(String word)
    {
        int newindex=modASCIIHashFunction(word, hashtable.length);
        boolean result=searchHashTable(word);
        if(result==true)
        {
            hashtable[newindex].remove(word);
            System.out.println("\n"+"\""+word+"\"" + " has been deleted from table");
        }
    }
    public static void main(String args[])
    {
        DirectChaining d=new DirectChaining(13);
        d.insertHashTable("The");
        d.insertHashTable("quick");
        d.insertHashTable("brown");
        d.insertHashTable("fox");
        d.insertHashTable("over");
        d.display();
        d.searchHashTable("fox");
        d.delete("brown");
        d.display();
    }
}

