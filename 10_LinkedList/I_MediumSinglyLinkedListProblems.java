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

// 11. Add Two Numbers (LeetCode 2) - [https://leetcode.com/problems/add-two-numbers/]
// 12. Reverse Linked List II (LeetCode 92) - [https://leetcode.com/problems/reverse-linked-list-ii/]
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

    // 11. Add Two Numbers (LeetCode 2)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1:  4->9->9->5->9   |    95994   |   49959
        // l2:  1->9->7         |  +   791   | + 197
        // sum: 5->8->7->6->9   |  = 96785   | = 58769

        ListNode p1 = l1, p2 = l2; // pointers to traverse both lists
        ListNode dummy = new ListNode(-1); // dummy node
        ListNode curr = dummy; // current pointer to track the sum
        int carry = 0;

        // add the values of nodes and carry
        while (p1 != null || p2 != null || carry != 0) {
            // sum = carry + p1.val + p2.val
            int sum = carry + (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0);
            
            int ld = sum % 10; // extract last digit of sum
            carry = sum / 10; // extract carry

            // make a new node of ld and add it to the list
            curr.next = new ListNode(ld);

            // move to next nodes
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
            curr = curr.next;
        }

        return dummy.next; // head of sum
    }
    
    // 12. Reverse Linked List II (LeetCode 92)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Using Arraylist - O(n) time and O(n) space
        // ListNode p1=head;
        // ListNode p2=head;

        // // move p1 to left
        // for(int i=1;i<left;i++){
        //     p1=p1.next;
        // }
        // // move p2 to right
        // for(int i=1;i<right;i++){
        //     p2=p2.next;
        // }
        
        // ArrayList<Integer> arr=new ArrayList<>();
        // // add the values of nodes from left to right in arraylist
        // ListNode temp=p1;
        // while(temp!=p2.next){
        //     arr.add(temp.val);
        //     temp=temp.next;
        // }

        // // from right to left, replace the values of nodes with arraylist values
        // int l = arr.size()-1;
        // while(p1!=p2.next){
        //     p1.val=arr.get(l);
        //     l--;
        //     p1=p1.next;
        // }

        // return head;

        // O(n) time and O(1) space
        if (head == null || head.next == null || left == right) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        // move prev to left-1
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next; // curr will be at left, after prev

        // reverse the nodes from left to right
        for (int i = 0; i < right - left; i++) {
            ListNode front = curr.next; // front will be after curr
            curr.next = front.next;
            front.next = prev.next;
            prev.next = front;
        }

        return dummy.next; // head
    }

    // 13. Sort List (LeetCode 148)
    public ListNode sortList(ListNode head) {

        // // Brute Force - O(nlogn) time and O(n) space
        // if(head==null || head.next==null) return head;

        // // add the values of nodes in arraylist
        // ListNode temp=head;
        // ArrayList<Integer> arr=new ArrayList<>();
        // while(temp!=null){
        //     arr.add(temp.val);
        //     temp=temp.next;
        // }

        // // sort the arraylist
        // Collections.sort(arr);

        // // replace the values of nodes with sorted arraylist values
        // temp=head;
        // int i=0;
        // while(temp!=null){
        //     temp.val=arr.get(i);
        //     i++;
        //     temp=temp.next;
        // }

        // return head;

        // Merge Sort - O(nlogn) time and O(logn) space

        if (head == null || head.next == null) return head;

        // find the middle
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // break the list into two halves
        prev.next = null;

        // sort the two halves
        ListNode leftHead = sortList(head);
        ListNode righthead = sortList(slow);

        // merge the two sorted halves
        return merge(leftHead, righthead);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // merge two sorted lists
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // attach any remaining elements
        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return dummy.next;
    }
    

    // 14. Sort a linked list of 0s, 1s and 2s (GFG)
    public static Node segregate(Node head) {
        // add the values of nodes in arraylist
        Node temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        // sort the arraylist
        Collections.sort(arr);

        // replace the values of nodes with sorted arraylist values
        temp = head;
        int i = 0;
        while (temp != null) {
            temp.val = arr.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }

    // 15. Add 1 to a Linked List Number (GFG)
    public Node addOne(Node head) {
        // reverse the list to add 1 from right
        head = reverse(head);

        Node curr = head;
        int carry = 1;

        while (carry != 0) {
            curr.val += 1; // adding one to current node

            if (curr.val < 10) return reverse(head);
            // if no carry we can reverse back list and return it
            else curr.val = 0;
            // else we continue with taking carry forward

            if (curr.next == null) break;
            // if end of list, we break from loop
            else curr = curr.next;
            // else we move to next node
        }

        curr.next = new Node(1); // adding new node for the carried 1
        
        // reverse the list back
        head = reverse(head);
        return head;
    }
    
    private static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;
    
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    
        return prev;
    }



}
