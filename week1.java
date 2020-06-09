import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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
        // Node root = new Node(10);
        // invertTree(root);
        char[] s = { 'a', 'b', 'c' };
        reverse(s);
        for (char ch : s) {
            System.out.println(ch);
        }
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

        // only node is given you need to delete that node
        // head is not given

        ListNode temp = node;
        ListNode pre = null;
        while (temp.next != null) {
            temp.val = temp.next.val;
            pre = temp;
            temp = temp.next;
        }
        pre.next = null;
    }

    public static void reverse(char[] s)

    {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static int twoCitySchedCost(int[][] costs) {
        int minCost = 0;

        int N = costs.length;
        for (int i = 0; i < N; i++) {
            minCost += costs[i][0];
        }

        int diff[] = new int[N];

        for (int i = 0; i < N; i++) {
            diff[i] = costs[i][1] - costs[i][0];
        }

        Arrays.sort(diff);

        for (int i = 0; i < diff.length / 2; i++) {
            minCost += diff[i];
        }
        return minCost;
    }

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }
        return list.toArray(people);
    }

    public static boolean isPowerOfTwo(int x) {
        if (x == 0) {
            return false;
        }

        while (x != 1) {
            if (x % 2 != 0) {
                return false;
            }
            x = x / 2;
        }
        return true;
    }

    public static boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;

            }
            j++;
        }
        return i == s.length();

    }
}