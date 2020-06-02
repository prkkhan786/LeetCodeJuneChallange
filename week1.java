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

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
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

    public void deleteNode(ListNode node) {

        //only node is given you need to delete that node 
        //head is not given 

        ListNode temp = node;
        ListNode pre = null;
        while (temp.next != null) {
            temp.val = temp.next.val;
            pre = temp;
            temp = temp.next;
        }
        pre.next = null;
    }

}