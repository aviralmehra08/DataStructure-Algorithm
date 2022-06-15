package Tree.BinaryTree;

public class BinaryTree
{
    String array[];
    int lastUsedIndex;
    public BinaryTree(int size)
    {
        array=new String[size+1];
        this.lastUsedIndex=0;
        System.out.println("Blank Tree of size "+size+" has been created");
    }
    public boolean isFull()
    {
        if(array.length==lastUsedIndex)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //insert
    public void insert(String value)
    {
        if(!isFull())
        {
            array[lastUsedIndex+1]=value;
            lastUsedIndex++;
            System.out.println("Value inserted");
        }
        else
        {
            System.out.println("BT is full");
        }
    }
    //preorder
    public void preorder(int index)
    {
        if(index>lastUsedIndex)
        {
            return;
        }
        System.out.println(array[index]+" ");
        preorder(index*2);
        preorder(index*2+1);
    }
    //inorder
    public void inorder(int index)
    {
        if(index>lastUsedIndex)
        {
            return;
        }
        preorder(index*2);
        System.out.println(array[index]+" ");
        preorder(index*2+1);
    }
    //postorder
    public void postorder(int index)
    {
        if(index>lastUsedIndex)
        {
            return;
        }
        preorder(index*2);
        preorder(index*2+1);
        System.out.println(array[index]+" ");
    }
    //levelorder
    public void levelorder()
    {
        for(int x=1;x<=lastUsedIndex;x++)
        {
            System.out.print(array[x] + " ");
        }
    }
    //search
    public int search(String value)
    {
        for(int x=1;x<=lastUsedIndex;x++)
        {
            if(array[x]==value)
            {
                System.out.println(value+" exists in location "+x);
                return x;
            }
        }
        System.out.println("Value not found");
        return -1;
    }
    //delete
    public void delete(String value)
    {
        int location=search(value);
        if(location==-1)
        {
            return;
        }
        else
        {
            array[location]=array[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("Deleted");
        }
    }
    //delete entire tree
    public void deleteBT()
    {
        try
        {
            array=null;
            System.out.println("BT has been deleted");
        }
        catch(Exception e)
        {
            System.out.println("Error while deleteing tree");
        }
    }
    public static void main(String args[])
    {
        BinaryTree b=new BinaryTree(5);
        b.insert("N1");
        b.insert("N2");
        b.insert("N3");
        b.insert("N4");
        b.insert("N5");
        b.insert("N6");
        b.preorder(1);
        b.inorder(1);
        b.postorder(1);
        b.levelorder();
        b.search("N4");
        b.delete("N5");
        b.deleteBT();
    }    
}
