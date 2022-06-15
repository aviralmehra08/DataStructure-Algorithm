package Tree.BinaryTree;
import java.util.LinkedList;
import java.util.Queue;
public class BinaryTreeLL
{
    BinaryNode root;
    public BinaryTreeLL()
    {
        this.root=null;
    }
    //Preorder Traversal
    public void preorder(BinaryNode node)
    {
        if(node==null)
        {
            return;
        }
        System.out.print(node.value+" ");//---->O(1)
        preorder(node.left);// ------> O(N/2)
        preorder(node.right);// -----> O(N/2)
    }
    //Inorder Traversal
    public void inorder(BinaryNode node)
    {
        if(node==null)
        {
            return;
        }
        inorder(node.left);// -----> O(N/2)
        System.out.print(node.value+" ");// ---->0(1)
        inorder(node.right);//---->O(N/2)
    }
    //Postorder Traversal
    public void postorder(BinaryNode node)
    {
        if(node==null)
        {
            return;
        }
        postorder(node.left);//----->O(N/2)
        postorder(node.right);//--->O(N/2)
        System.out.print(node.value+" ");//---->O(N)
    }
    //Level-Order
    public void levelOrder()
    {
        Queue<BinaryNode> queue=new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty())//-----> O(N)
        {
            BinaryNode presentNode=queue.remove();
            System.out.println(presentNode.value+" ");
            if(presentNode.left!=null)
            {
                queue.add(presentNode.left);
            }
            if(presentNode.right!=null)
            {
                queue.add(presentNode.right);
            }
        }
    }
    //Search
    public void search(String value)
    {
        Queue<BinaryNode> queue=new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            BinaryNode presentNode=queue.remove();
            if(presentNode.value==value)
            {
                System.out.println("Value "+ value+ " found in Tree");
                return;
            }
            else
            {
                if(presentNode.left!=null)
                {   
                    queue.add(presentNode.left);
                }
                if(presentNode.right!=null)
                {
                    queue.add(presentNode.right);
                }   
            }
        }
        System.out.println("Value not found");
        return;
    }
    //Insert
    public void insert(String value)
    {
        BinaryNode newnode=new BinaryNode();
        newnode.value=value;
        if(root==null)
        {
            root=newnode;
            System.out.println("Inserted");
            return;
        }
        Queue<BinaryNode> queue=new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            BinaryNode presentNode=queue.remove();
            if(presentNode.left==null)
            {
                presentNode.left=newnode;
                System.out.println("Inserted");
                break;
            }
            else if(presentNode.right==null)
            {
                presentNode.right=newnode;
                System.out.println("Inserted");
                break;
            }
            else
            {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }
    //Get the deepest node
    public BinaryNode getdeepestnode()
    {
        Queue<BinaryNode> queue=new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode presentNode=null;
        while(!queue.isEmpty())
        {
            presentNode=queue.remove();
            if(presentNode.left!=null)
            {
                queue.add(presentNode.left);
            }
            if(presentNode.right!=null)
            {
                queue.add(presentNode.right);
            }
        }
        return presentNode;
    }
    //Delete deepest node
    public void deletedeepestNode()
    {
        Queue<BinaryNode> queue=new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode previousNode, presentNode=null;
        while(!queue.isEmpty())
        {
            previousNode=presentNode;
            presentNode=queue.remove();
            if(presentNode.left==null)
            {
                previousNode.right=null;
                return;
            }
            else if(presentNode.right==null)
            {
                presentNode.left=null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }
    //Delete the given node
    public void deleteNode(String value)
    {
        Queue<BinaryNode> queue=new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            BinaryNode presentNode=queue.remove();
            if(presentNode.value==value)
            {
                presentNode.value=getdeepestnode().value;
                deletedeepestNode();
                System.out.println("The Node is deleted");
                return;
            }
            else
            {
                if(presentNode.left!=null)
                {
                    queue.add(presentNode.left);                
                }
                if(presentNode.right!=null)
                {
                    queue.add(presentNode.right);
                }
            }
            System.out.println("The node does not exist");
        }   
    }
    //Delete Entire Binary Tree
    public void deleteBT()
    {
        root=null;
        System.out.println("BT has been deleted");
    }
    public static void main(String args[])
    {
        BinaryTreeLL b=new BinaryTreeLL();
        // BinaryNode N1=new BinaryNode();
        // N1.value="N1";
        // BinaryNode N2=new BinaryNode();
        // N2.value="N2";
        // BinaryNode N3=new BinaryNode();
        // N3.value="N3";
        // BinaryNode N4=new BinaryNode();
        // N4.value="N4";
        // BinaryNode N5=new BinaryNode();
        // N5.value="N5";
        // BinaryNode N6=new BinaryNode();
        // N6.value="N6";
        // BinaryNode N7=new BinaryNode();
        // N7.value="N7";
        // BinaryNode N8=new BinaryNode();
        // N8.value="N8";
        // BinaryNode N9=new BinaryNode();
        // N9.value="N9";
        // N1.left=N2;
        // N1.right=N3; 
        // N2.left=N4;
        // N2.right=N5;
        // N3.left=N6;
        // N3.right=N7;
        // N4.left=N8;
        // N4.right=N9;
        // b.root=N1;
        
        b.insert("N1");
        b.insert("N2");
        b.insert("N3");
        b.insert("N4");
        b.insert("N5");
        b.insert("N6");
        b.insert("N7");
        b.insert("N8");
        b.insert("N9");
        // b.preorder(b.root);
        // b.inorder(b.root);
        // b.postorder(b.root);
        b.levelOrder();
        // b.search("N5");
        b.deletedeepestNode();
        b.deleteNode("N3");
        System.out.println();
        b.levelOrder();
    }    
}
