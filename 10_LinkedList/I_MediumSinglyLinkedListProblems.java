// 1. Middle of the Linked List (LeetCode 876) - [https://leetcode.com/problems/middle-of-the-linked-list/]
// 2. Reverse Linked List (LeetCode 206) - [https://leetcode.com/problems/reverse-linked-list/]
// 3. Palindrome Linked List (LeetCode 234) - [https://leetcode.com/problems/palindrome-linked-list/]
// 4. Odd Even Linked List (LeetCode 328) - [https://leetcode.com/problems/odd-even-linked-list/]
// 5. Delete the Middle Node of a Linked List (LeetCode 2095) - [https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/]
// 6. Intersection Point of Two Linked Lists (LeetCode 160) - [https://leetcode.com/problems/intersection-of-two-linked-lists/]
// 7. Remove Nth Node From End of List (LeetCode 19) - [https://leetcode.com/problems/remove-nth-node-from-end-of-list/]

// 8. Linked List Cycle (LeetCode 141) - [https://leetcode.com/problems/linked-list-cycle/]
// 9. Linked List Cycle II (LeetCode 142) - [https://leetcode.com/problems/linked-list-cycle-ii/]
// 10. Find length of Loop (GFG) - [https://www.geeksforgeeks.org/problems/find-length-of-loop/1]

// 11. Reverse Linked List II (LeetCode 92) - [https://leetcode.com/problems/reverse-linked-list-ii/]
// 12. Add Two Numbers (LeetCode 2) - [https://leetcode.com/problems/add-two-numbers/]
// 13. Sort List (LeetCode 148) - [https://leetcode.com/problems/sort-list/]

// 14. Sort a linked list of 0s, 1s and 2s (GFG) - [https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1]
// 15. Add 1 to a Linked List Number (GFG) - [https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1]


public class I_MediumSinglyLinkedListProblems {
    
    // Node class of linked list
    public static class ListNode {
        int val; // Value
        ListNode next; // Address of next Node

        ListNode (int val) { // Constructor
            this.val = val;
        }
    }

    // 1. Middle of the Linked List (LeetCode 876)
    public ListNode middleNode(ListNode head) {
        // Floyd's Tortoise and Hare Algorithm - Slow and Fast Pointers
        // (right middle for even length)
        ListNode slow = head;
        ListNode fast = head;

        // move slow by 1 and fast by 2
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 2. Reverse Linked List (LeetCode 206)
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        head = prev;
        return head;
    }

    public ListNode reverseListRec(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseListRec(head.next);
        head.next.next = head; 
        head.next = null;

        return newHead;
    }

    // 3. Palindrome Linked List (LeetCode 234) 
    public boolean isPalindrome(ListNode head) {
        // find the middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half
        ListNode rev = reverseList(slow);
        ListNode curr = head;

        // compare the first and second half
        while(rev != null){
            if(rev.val != curr.val) return false;
            rev = rev.next;
            curr = curr.next;
        }

        return true;
    }

    
    // 4. Odd Even Linked List (LeetCode 328)
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // save the head of even

        // separate odd and even
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }

        // connect even after odd
        odd.next = evenHead;
        return head;
    }

    // 5. Delete the Middle Node of a Linked List (LeetCode 2095)
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        return head;
    }

    // 6. Intersection Point of Two Linked Lists (LeetCode 160)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // traverse both lists till they meet
        while(a != b){
            // if a reaches end, move it to headB else move it to next
            if (a == null) a = headB;
            else a = a.next;
            // if b reaches end, move it to headA else move it to next
            if (b == null) b = headA;
            else b = b.next;
        }

        return a;
    }

    // 7. Remove Nth Node From End of List (LeetCode 19)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        // move fast by n
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        // if fast is null, remove head
        if (fast == null) {
            return head.next;
        }

        // move slow and fast till fast reaches end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // remove the nth node
        slow.next = slow.next.next;

        return head;
    }

    // 8. Linked List Cycle (LeetCode 141)
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }

    // 9. Linked List Cycle II (LeetCode 142)
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // cycle detected
                // find the cycle start by moving slow to head
                ListNode temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }

        return null; // no cycle
    }

    // 10. Find length of Loop (GFG)
    public int countNodesinLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){ // cycle detected
                int count = 1;
                ListNode temp = slow;
                while(temp.next != slow){
                    count++;
                    temp = temp.next;
                }
                return count;
            }
        }

        return 0;
    }


    // 11. Reverse Linked List II (LeetCode 92)
    // -- Concept of Dummy Node in Linked List


    // 12. Add Two Numbers (LeetCode 2)

    // 13. Sort List (LeetCode 148)

    // 14. Sort a linked list of 0s, 1s and 2s (GFG)

    // 15. Add 1 to a Linked List Number (GFG)



}
