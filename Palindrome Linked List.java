Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        int length=0;
        
     
        Stack<Integer> st=new Stack<>();

        while(fast!=null&&fast.next!=null){
            st.push(slow.val);
            slow=slow.next;
            fast=fast.next.next;           
        }
        if(fast!=null) slow=slow.next;
      
        while(slow!=null){
            if(slow.val==st.peek()){
                st.pop();
            }
            
            slow=slow.next;
        }
        return st.isEmpty();
    }
}
