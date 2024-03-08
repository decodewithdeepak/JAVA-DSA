// Notes : https://drive.google.com/file/d/14heWSZJBc_-EJQ8M0l4Ft9toK_QgWjGq/view

// Problems on Linked List (Singly) - leetcode

// 1. Delete node with node as given parameter - Problem 237 (https://leetcode.com/problems/delete-node-in-a-linked-list/)
// 2. Find Nth node from end
// 3. Delete Nth node from end - Problem 19 (https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
// 4. Intersection of two linked lists - Problem 160 (https://leetcode.com/problems/intersection-of-two-linked-lists/)
// 5. Find middle element of linked list - Problem 876 (https://leetcode.com/problems/middle-of-the-linked-list/)
// 6. Delete middle element of linked list - Problem 2095 (https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/)
// 7. Linked List Cycle - Problem 141 (https://leetcode.com/problems/linked-list-cycle/)
// 8. Linked List Cycle 2 - Problem 142 (https://leetcode.com/problems/linked-list-cycle-ii/)
// 9. Merge 2 sorted Linked Lists - O(n) space - Problem 21 (https://leetcode.com/problems/merge-two-sorted-lists/)
// 10. Merge 2 sorted Linked Lists - O(1) space
// 11. Remove duplicates from sorted linked list - Problem 83 (https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
// 12. Odd Even Linked List - Problem 328 (https://leetcode.com/problems/odd-even-linked-list/)
// 13. Split LinkedList into 2 lists with odd and even values
// 14. Reverse a linked list - recursive - Problem 206 (https://leetcode.com/problems/reverse-linked-list/)
// 15. Reverse a linked list - iterative
// 16. Palindrome Linked List - Problem 234 (https://leetcode.com/problems/palindrome-linked-list/)
// 17. Maximum Twin Sum of a Linked List - Problem 2130 (https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/)
// 18. Copy List with Random Pointer - Problem 138 (https://leetcode.com/problems/copy-list-with-random-pointer/)

public class LinkedListProblems {

    // Node class of linked list
    public static class ListNode {
        int val; // Value
        ListNode next; // Address of next Node

        ListNode (int val) {
            this.val = val;
        }

        ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 1. Delete node with node as given parameter - Problem 237
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // 2. Find Nth node from end
    public ListNode findNthNodeFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // 3. Delete Nth node from end - Problem 19
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
    
    // 4. Intersection of two linked lists - Problem 160
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        int lenA = 0;
        int lenB = 0;

        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                tempA = tempA.next;
            }
        } 
        else {
            for (int i = 0; i < lenB - lenA; i++) {
                tempB = tempB.next;
            }
        }

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;
    }

    // 5. Find middle element of linked list - Problem 876
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Second middle for even length linked list
        while (fast != null && fast.next != null) { // fast.next != null is used to handle even length linked list
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 6. Delete middle element of linked list - Problem 2095
    public ListNode deleteMiddleNode(ListNode head) {
        if (head.next == null) { // Single node linked list
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next.next != null && fast.next.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 1 2 3 4 5
        // 2 -> slow, 3 -> slow.next, 4 -> slow.next.next 
        slow.next = slow.next.next;
        return head;
    }

    // 7. Linked List Cycle - Problem 141
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) { // fast.next != null is used to handle single node linked list
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // 8. Linked List Cycle 2 - Problem 142
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) { // fast.next != null is used to handle single node linked list
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }

        return null; // No cycle
    }

    // 9. Merge 2 sorted Linked Lists - O(n) space - Problem 21
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) { // O(n) space
        ListNode temp1 = list1; // head of list1
        ListNode temp2 = list2; // head of list2
        
        ListNode dummy = new ListNode(0); // Dummy node to start the merged list
        ListNode temp = dummy; // Pointer to dummy node
    
        // Traverse both lists until we reach the end of one of the lists
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
    
        if (temp1 != null) {
            temp.next = temp1;
        } else {
            temp.next = temp2;
        }
    
        return dummy.next;
    }
    // The time complexity of this mergeTwoLists function is O(n), where n is the total number of nodes in both input lists. This is because we iterate through both lists once to merge them in sorted order.
    // The space complexity is also O(n) because we are creating a new ListNode for each node in the merged list. Additionally, we are using a constant amount of extra space for pointers and variables.
    

    // 10. Merge 2 sorted Linked Lists - O(1) space
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) { // O(1) space
        ListNode dummy = new ListNode(0); // Dummy node to start the merged list
        ListNode current = dummy; // Pointer to dummy node
    
        // Traverse both lists until we reach the end of one of the lists
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
    
        // Attach remaining nodes of list1 or list2, if any
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
    
        return dummy.next;
    }
    
    // The time complexity of this mergeTwoLists1 function is O(n), where n is the total number of nodes in both input lists. This is because we iterate through both lists once to merge them together. 
    // The space complexity is O(1) because we only use a constant amount of extra space for the dummy node and a few pointers, regardless of the size of the input lists.

    // 11. Remove duplicates from sorted linked list - Problem 83
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next; // Skip the duplicate node
            } else {
                temp = temp.next;
            }
        }
        
        return head;
    }

    // 12. Odd Even Linked List - Problem 328
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        
        return head;
    }


    // 13. Split LinkedList into 2 lists with odd and even values
    public ListNode[] splitListIntoOddEven(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddHead = odd;
        ListNode evenHead = even;

        while (head != null) {
            if (head.val % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
        }

        even.next = null;
        odd.next = evenHead.next;

        return new ListNode[] {oddHead.next, evenHead.next};
    }

    // 14. Reverse a linked list - recursive - Problem 206
    public ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) { // Base case
            return head;
        }
        
        ListNode newHead = reverseList(head.next); // Recursive call
        head.next.next = head; // Self work
        head.next = null;
        
        return newHead;
    }

    // 15. Reverse a linked list - iterative - SC- O(1)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // 16. Palindrome Linked List - Problem 234
    public boolean isPalindrome(ListNode head) {
        
        // Find the middle of the linked list (first middle)
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        slow = reverseList(slow);
        fast = head;

        // Compare the first and second half of the linked list
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    // 17. Maximum Twin Sum of a Linked List - Problem 2130 
    public int pairSum(ListNode head) {
        // Find middle of the linked list
        ListNode middle = findMiddle(head);
        // Reverse the second half of the linked list
        ListNode secondHalf = reverseList(middle); // Store the head of the second half
        // Pair sum
        int maxSum = 0;
        while (head != null && secondHalf != null) {
            maxSum = Math.max(maxSum, head.val + secondHalf.val);
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return maxSum;
    }

    // 18. Copy List with Random Pointer - Problem 138


    public static void main(String[] args) {
        
    }

}
