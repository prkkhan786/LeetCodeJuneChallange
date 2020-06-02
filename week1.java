/**
 * week1
 */

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class week1 {

    public static void main(String[] args) {
        Node root = new Node(10);
        invertTree(root);
    }

    public static Node invertTree(Node root) {
        return invertTreeHelper(root);
    }

    private static Node invertTreeHelper(Node temp) {
        if (temp == null) {
            return temp;
        }
        Node left = invertTreeHelper(temp.left);
        Node right = invertTreeHelper(temp.right);

        temp.left = right;
        temp.right = left;
        return temp;
    }

}