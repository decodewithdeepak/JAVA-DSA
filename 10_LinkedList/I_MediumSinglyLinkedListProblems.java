// 1. Middle of the Linked List (LeetCode 876) - [https://leetcode.com/problems/middle-of-the-linked-list/]
// 2. Reverse Linked List (LeetCode 206) - [https://leetcode.com/problems/reverse-linked-list/]
// 3. Reverse Linked List II (LeetCode 92) - [https://leetcode.com/problems/reverse-linked-list-ii/]
// 4. Palindrome Linked List (LeetCode 234) - [https://leetcode.com/problems/palindrome-linked-list/]
// 5. Linked List Cycle (LeetCode 141) - [https://leetcode.com/problems/linked-list-cycle/]
// 6. Linked List Cycle II (LeetCode 142) - [https://leetcode.com/problems/linked-list-cycle-ii/]
// 7. Odd Even Linked List (LeetCode 328) - [https://leetcode.com/problems/odd-even-linked-list/]
// 8. Remove Nth Node From End of List (LeetCode 19) - [https://leetcode.com/problems/remove-nth-node-from-end-of-list/]
// 9. Add Two Numbers (LeetCode 2) - [https://leetcode.com/problems/add-two-numbers/]
// 10. Delete the Middle Node of a Linked List (LeetCode 2095) - [https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/]
// 11. Sort List (LeetCode 148) - [https://leetcode.com/problems/sort-list/]
// 12. Find length of Loop (GFG) - [https://www.geeksforgeeks.org/problems/find-length-of-loop/1]
// 13. Sort a linked list of 0s, 1s and 2s (GFG) - [https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1]
// 14. Add 1 to a Linked List Number (GFG) - [https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1]


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
        ListNode slow = head;
        ListNode fast = head;

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
 
    // 3. Reverse Linked List II (LeetCode 92)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        for(int i = 1; i < left; i++){
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode front = curr.next;

        for(int i = 0; i < right - left; i++){
            curr.next = front.next;
            front.next = prev.next;
            prev.next = front;
            front = curr.next;
        }

        return dummy.next;
    }

    // 4. Palindrome Linked List (LeetCode 234)
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverseList(slow);
        ListNode curr = head;

        while(rev != null){
            if(rev.val != curr.val) return false;
            rev = rev.next;
            curr = curr.next;
        }

        return true;
    }

    // 5. Linked List Cycle (LeetCode 141)
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

    // 6. Linked List Cycle II (LeetCode 142)
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // cycle detected
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

    // 7. Odd Even Linked List (LeetCode 328)
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    // 8. Remove Nth Node From End of List (LeetCode 19)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

}
