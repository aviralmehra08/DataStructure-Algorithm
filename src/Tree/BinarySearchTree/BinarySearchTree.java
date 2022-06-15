package Tree.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree
{   
    BinaryNode root;
    public BinarySearchTree()
    {
        root=null;
    }
    //insert
    public BinaryNode insert(BinaryNode currentNode, int value)
    {
        if(currentNode==null)
        {
            BinaryNode newnode=new BinaryNode();
            newnode.value=value;
            System.out.println("Value inserted");
            return newnode;
        }
        else if(value<=currentNode.value)
        {
            currentNode.left=insert(currentNode.left, value);//----->O(N/2)
            return currentNode;
        }
        else
        {
            currentNode.right=insert(currentNode.right, value);//---->O(N/2)
            return currentNode;
        }
    }
    public void insert(int value)
    {
        insert(root, value);
    }
    //preorder
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
    //inorder
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
    //postorder
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
    //level-order
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
    //search
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
    //Minimum Node
    public static BinaryNode minimumNode(BinaryNode root)
    {
        if(root.left==null)
        {
            return root;
        }
        else
        {
            return minimumNode(root.left);
        }
    }
    //Delete Node
    public BinaryNode deleteNode(BinaryNode root,int value)
    {
        if(root==null)
        {
            System.out.println("Node not found");
            return null;
        }
        if(value<root.value)
        {
            root.left=deleteNode(root.left, value);
        }
        else if(value>root.value)
        {
            root.right=deleteNode(root.right, value);
        }
        else
        {
            if(root.left!=null && root.right!=null)
            {
                BinaryNode temp=root;
                BinaryNode minNodeForRight=minimumNode(temp.right);
                root.value=minNodeForRight.value;
                root.right=deleteNode(root.right, minNodeForRight.value);
            }
            else if(root.left!=null)
            {
                root=root.left;
            }
            else if(root.right!=null)
            {
                root=root.right;
            }
            else
            {
                root=null;
            }
        }
        return root;
    }
    //delete entire BST
    public void deleteBST()
    {
        root=null;
        System.out.println("Deleted");
    }
    public static void main(String args[])
    {
        BinarySearchTree b=new BinarySearchTree();
        b.insert(70);
        b.insert(50);
        b.insert(90);
        b.insert(30);
        b.insert(60);
        b.insert(80);
        b.insert(100);
        b.insert(20);
        b.insert(40);
        b.preorder(b.root);
        b.inorder(b.root);
        b.postorder(b.root);
        b.levelorder();
        b.deleteNode(b.root, 90);
    }
}
