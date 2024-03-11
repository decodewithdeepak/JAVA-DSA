// Problems on Doubly Linked List

// 1. Palindrome checking in a doubly linked list
// 2. Two Sum in a sorted doubly linked list
// 3. Critical Point - Maxima and Minima of a Doubly Linked List
// 4. Flatten a multilevel doubly linked list - LeetCode 430 - https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

public class DoublyLinkedListProblems {

    // Node class
    public static class Node {
        int data;
        Node next;
        Node prev;
        Node child;
        Node(int data) {
            this.data = data;
        }
    }
    
    // 1. Palindrome checking in a doubly linked list

    // 2. Two Sum in a sorted doubly linked list

    // 3. Maxima and Minima of a Doubly Linked List

    // 4. Flatten a multilevel doubly linked list
    public static Node flatten(Node head) {
        if (head == null) return head;
        Node curr = head;
        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }
            Node temp = curr.child;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = temp;
            }
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
        }
        return head;
    }


}
