// 1. Array to Linked List (GFG) - [https://www.geeksforgeeks.org/problems/introduction-to-linked-list/1]
// 2. Linked List Insertion At End (GFG) - [https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0]
// 3. Delete Node in a Linked List (Leetcode 237) - [https://leetcode.com/problems/delete-node-in-a-linked-list/]
// 4. Count Linked List Nodes (GFG) - [https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/0]
// 5. Search in Linked List (GFG) - [https://www.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1]
// 6. Convert Binary Number in a Linked List to Integer (Leetcode 1290) - [https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/]


public class G_EasySinglyLinkedListProblems {

    // Node class of linked list
    public static class Node {
        int data; // Value
        Node next; // Address of next Node

        Node (int data) { // Constructor
            this.data = data;
        }
    }

    // 1. Array to Linked List (GFG)
    public static Node constructLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    // 2. Linked List Insertion At End (GFG)
    public static Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        if (head == null) return newNode; // if list is empty
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    // 3. Delete Node in a Linked List (Leetcode 237)
    public static void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    // 4. Count Linked List Nodes (GFG)
    static int countNodes(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // 5. Search in Linked List (GFG)
    static boolean searchKey(int n, Node head, int key) {
        while (head != null) {
            if (head.data == key) return true;
            head = head.next;
        }
        return false;
    }

    // 6. Convert Binary Number in a Linked List to Integer (Leetcode 1290)
    public static int getDecimalValue(Node head) {
        int num = 0;
        while (head != null) {
            num = num * 2 + head.data;
            head = head.next;
        }
        return num;
    }


}
