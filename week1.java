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
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        // System.out.println(BinarySearch(arr, 909));

        int ar[] = { 2, 0, 2, 1, 1, 0 };
        sortColorInOnePass(ar);
        for (int val : ar) {
            System.out.println(val + " ");
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

    public static int BinarySearch(int arr[], int target) {

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int searchInsert(int arr[], int target) {

        int left = 0;
        int right = arr.length - 1;
        int pos = 0;

        while (left <= right) {

            int mid = (left + right) / 2;
            if (target < arr[mid]) {
                right = mid - 1;
                pos = mid;
            } else if (target > arr[mid]) {

                left = mid + 1;
                pos = mid + 1;

            } else {
                return mid;
            }

        }
        return pos;

    }

    public static void sortColors(int nums[]) {

        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                redCount++;

            } else if (nums[i] == 1) {
                whiteCount++;

            } else {
                blueCount++;

            }
        }

        int count = 0;
        for (int i = 1; i <= redCount; i++) {
            nums[count++] = 0;
        }
        for (int i = 1; i <= whiteCount; i++) {
            nums[count++] = 1;
        }
        for (int i = 1; i <= blueCount; i++) {
            nums[count++] = 2;
        }
    }

    public static void sortColorInOnePass(int arr[]) {
        int left = 0;
        int mid = 0;
        int right = arr.length - 1;

        while (mid < right) {
            if (arr[mid] == 0) {
                swap(arr, left, mid);
                left++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;

            } else {
                swap(arr, mid, right);
                right--;
            }
        }

    }

    public static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}