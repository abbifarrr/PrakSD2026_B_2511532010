package pekan9_2511532010;

public class Node_2511532010 {
    int data;
    Node_2511532010 left;
    Node_2511532010 right;

    public Node_2511532010(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void setLeft(Node_2511532010 node) {
        if (left == null)
            left = node;
    }

    public void setRight(Node_2511532010 node) {
        if (right == null)
            right = node;
    }

    public Node_2511532010 getLeft() {
        return left;
    }

    public Node_2511532010 getRight() {
        return right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    // Traversal Methods
    void printPreorder(Node_2511532010 node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printPostorder(Node_2511532010 node) {
        if (node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    void printInorder(Node_2511532010 node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }


    public void print() {

        this.print("", true);
    }

    public void print(String prefix_2010, boolean isTail_2010) {
        if (right != null) {
            right.print(prefix_2010 + (isTail_2010 ? "|   " : "    "), false);
        }
        

        System.out.println(prefix_2010 + (isTail_2010 ? "\\-- " : "/-- ") + data);
        
        if (left != null) {
            left.print(prefix_2010 + (isTail_2010 ? "    " : "|   "), true);
        }
    }
}