package gradedCodingAssignment3;

class Node
{
    int val;
    Node left, right;
    Node(int item)
    {
        val = item;
        left = right = null;
    }
}
class CovertBinarySearchTreeToSkewedTree
{
    public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
    static void flattenBSToSkewed(Node root,int order)
    {
        if(root == null)
        {
            return;
        }
        if(order > 0)
        {
        	flattenBSToSkewed(root.right, order);
        }
        else
        {
        	flattenBSToSkewed(root.left, order);
        }
        Node rightNode = root.right;
        Node leftNode = root.left;
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
       
        if (order > 0)
        {
        	flattenBSToSkewed(leftNode, order);
        }
        else
        {
        	flattenBSToSkewed(rightNode, order);
        }
    }
    static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        traverseRightSkewed(root.right);       
    }
   
    public static void main (String[] args)
    {
    	CovertBinarySearchTreeToSkewedTree tree = new CovertBinarySearchTreeToSkewedTree();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);
       
        // Order of the Skewed tree can
        // be defined as follows -
        // For Increasing order - 0
        // For Decreasing order - 1
        int order = 0;
        flattenBSToSkewed(node, order);
        traverseRightSkewed(headNode);
    }
}