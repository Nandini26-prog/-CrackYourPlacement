You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
  

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode second = slow.next;
        slow.next = null;  // Split the list into two halves
        ListNode prev = null;

        while (second != null) {
            ListNode newNode = second.next;
            second.next = prev;
            prev = second;
            second = newNode;
        }
        second = prev;  
        fast = head;
        while (second != null) {
            ListNode tmp1 = fast.next;
            ListNode tmp2 = second.next;

            fast.next = second;
            second.next = tmp1;

            fast = tmp1;
            second = tmp2;
        }
    }
}
