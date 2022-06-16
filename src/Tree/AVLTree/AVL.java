package Tree.AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVL
{
    BinaryNode root;
    //Constructor
    public AVL()
    {
        root=null;
    }
    //Insertion     
    //CASE 1: IF Rotation is not required  
    //CASE 2: IF Rotation is required  :-   LL(right rotation),LR,RR,RL conditions
    //Preorder Traversal
    //getHeight
    public int getHeight(BinaryNode node)
    {
        if(node==null)
        {
            return 0;
        }
        return node.height;
    }
    //rotate right
    public BinaryNode rotateRight(BinaryNode disbalancednode)
    {
        BinaryNode newroot=disbalancednode.left;
        disbalancednode.left=disbalancednode.left.right;
        newroot.right=disbalancednode;
        disbalancednode.height=1+Math.max(getHeight(disbalancednode.left),getHeight(disbalancednode.right));
        newroot.height=1+Math.max(getHeight(newroot.left), getHeight(newroot.right));
        return newroot;
    }
    //rotate left
    public BinaryNode rotateleft(BinaryNode disbalancenode)
    {
        BinaryNode newroot=disbalancenode.right;
        disbalancenode.right=disbalancenode.right.left;
        newroot.left=disbalancenode;
        disbalancenode.height=1+Math.max(getHeight(disbalancenode.left),getHeight(disbalancenode.right));
        newroot.height=1+Math.max(getHeight(newroot.left), getHeight(newroot.right));
        return newroot;
    }
    //get Balance
    public int getBalance(BinaryNode node)
    {
        if(node==null)
        {
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }
    //insertNode method
    public BinaryNode insernode(BinaryNode node, int nodevalue)
    {
        if(node==null)
        {
            BinaryNode newnode=new BinaryNode();
            newnode.value=nodevalue;
            newnode.height=1;
            return newnode;
        }
        else if(nodevalue<node.value)
        {
            node.left=insernode(node.left, nodevalue);
        }
        else
        {
            node.right=insernode(node.right, nodevalue);
        }
        node.height=1+Math.max(getHeight(node.left), getHeight(node.right));
        int balance=getBalance(node);
        if(balance>1 && nodevalue<node.left.value)
        {
            return rotateRight(node);
        }
        if(balance>1 && nodevalue>node.left.value)
        {
            node.left=rotateleft(node.left);
            return rotateRight(node);
        }
        if(balance<-1&& nodevalue>node.right.value)
        {
            return rotateleft(node);
        }
        if(balance<-1 && nodevalue<node.right.value)
        {
            node.right=rotateRight(node.right);
            return rotateleft(node);
        }
        return node;
    }
    public void insert(int value)
    {
        root=insernode(root, value);
    }
    public void preorder(BinaryNode node)
    {
        if(node==null)
        {
            return;
        }
        System.out.println(node.value+" ");
        preorder(node.left);
        preorder(node.right);
    }
    //Inorder Traversal
    public void inorder(BinaryNode node)
    {
        if(node==null)
        {
            return;
        }
        inorder(node.left);
        System.out.println(node.value+" ");
        inorder(node.right);
    }
    //Postorder Traversal
    public void postorder(BinaryNode node)
    {
        if(node==null)
        {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value+" ");
    }
    //Level Order Traversal
    public void levelorder()
    {
        Queue<BinaryNode> queue=new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty())
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
    public BinaryNode search(BinaryNode node,int value)
    {
        if(node==null)
        {
            System.out.println("Value not found");
            return null;
        }
        else if(node.value==value)
        {
            System.out.println("Value found");
            return node;
        }
        else if(value<=node.value)
        {
            return search(node.left,value);//---->O(N/2)
        }
        else
        {
            return search(node.right,value);//---->O(N/2)
        }
    }
    //Minimum node
    public static BinaryNode minimumNode(BinaryNode root)
    {
        if(root.left==null)
        {
            return root;
        }
        return minimumNode(root.left);
    }
    //Delete Node
    public BinaryNode deleteNode(BinaryNode node, int value)
    {
        if(node==null)
        {
            System.out.println("Value not found in AVL");
            return node;
        }
        if(value<node.value)
        {
            node.left=deleteNode(node.left, value);
        }
        else if(value>node.value)
        {
            node.right=deleteNode(node.right, value);
        }
        else
        {
            if(node.left!=null && node.right!=null)
            {
                BinaryNode temp=node;
                BinaryNode minNodeForRight=minimumNode(temp.right);
                node.value=minNodeForRight.value;
                node.right=deleteNode(node.right, minNodeForRight.value);
            }
            else if(node.left!=null)
            {
                node=node.left;
            }
            else if(node.right!=null)
            {
                node=node.right;
            }
            else
            {
                node=null;
            }
        }
        int balance=getBalance(node);
        if(balance>1 && getBalance(node.left)>=0)
        {
            return rotateRight(node);
        }
        if(balance>1 && getBalance(node.left)<0)
        {
            node.left=rotateleft(node.left);
            return rotateRight(node);
        }
        if(balance<-1 && getBalance(node.right)<=0)
        {
            return rotateleft(node);
        }
        if(balance<-1 && getBalance(node.right)>0)
        {
            node.right=rotateRight(node.right);
            return rotateleft(node);
        }
        return node;
    }
    public void delete(int value)
    {
        root=deleteNode(root, value);
    }
    public void deletAll()
    {
        root=null;
        System.out.println("Deleted entire AVL");
    }
    public static void main(String args[])
    {
        AVL avl=new AVL();
        avl.insert(5);
        avl.insert(10);
        avl.insert(15);
        avl.insert(20);
        avl.preorder(avl.root);
        avl.inorder(avl.root);
        avl.postorder(avl.root);
        avl.levelorder();
        avl.delete(5);
        avl.levelorder();
        avl.deletAll();
    }
}
