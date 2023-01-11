import java.util.*;

/**
 * This BinarySearchTree object defines a reference based binary search tree
 * 
 * @author  
 * @version 
 */

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>
{
    protected BinaryNode<T> root;      // reference to the root of this BST

    // Creates an empty Binary Search Tree object
    public BinarySearchTree()
    {
        root = null;
    }

    // Returns true if this BST is empty; otherwise, returns false.
    public boolean isEmpty()
    {
        return root==null;
    }

    // Returns the number of elements in this BST.
    public int size()
    {
        return size(root);
    }
    public int size(BinaryNode<T> node) {
        return (node==null? 0 : 1+ (size(node.getRight()) + size(node.getLeft())));
    }
    // Adds element to this BST. The tree retains its BST property.
    public void add (T element)
    {
        BinaryNode<T> node = root;
        BinaryNode<T> newNode = new BinaryNode(element);
        if(root==null) {
            root = newNode;
            return;
        }
        while(true) {
            if(node.getInfo().compareTo(element)>=0) {
                if(node.getLeft()==null) {
                    node.setLeft(newNode);
                    break;
                }
                node = node.getLeft();
            } else {
                if(node.getRight()==null) {
                    node.setRight(newNode);
                    break;
                }
                node = node.getRight();
            }
        }
    }

    // Returns true if this BST contains an element e such that 
    // e.compareTo(element) == 0; otherwise, returns false.
    public boolean contains (T element)
    {
        return contains(element, root);
    }

    public boolean contains(T element, BinaryNode<T> node) {
        if(node==null) {
            return false;
        } else if (node.getInfo().equals(element)){
            return true;
        } else {
            return contains(element, node.getLeft()) || contains(element, node.getRight());
        }
    }

    // Returns a graphical representation of the tree
    public String toString()
    {
        return toString(root, 0);
    }

    private String toString(BinaryNode<T> tree, int level)
    {
        String str = "";
        if (tree != null)
        {
            str += toString(tree.getRight(), level + 1);
            for (int i = 1; i <= level; ++i)
                str = str + "| ";
            str += tree.getInfo().toString() + "\n";
            str += toString(tree.getLeft(), level + 1);
        }
        return str;
    }

    // Returns a list of elements from a preorder traversal
    public List<T> preorderTraverse()
    {
        return null;
    }

    // Returns a list of elements from an inorder traversal
    public List<T> inorderTraverse()
    {
        return null;
    }

    // Returns a list of elements from a postorder traversal
    public List<T> postorderTraverse()
    {
        return null;
    }

    // Removes an element e from this BST such that e.compareTo(element) == 0
    public void remove (T element)
    {
    }

    // Restructures this BST to be optimally balanced
    public void balance()
    {
    }
}