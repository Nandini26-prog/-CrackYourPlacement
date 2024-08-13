You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
  // /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
//class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         int carry=0;
//         ListNode curr1=l1,curr2=l2;
//         ListNode dummy=new ListNode(0);
//         ListNode curr3=dummy;
//         int length1=0,length2=0;
//         while(curr1!=null){
//             length1++;
//             curr1=curr1.next;
//         }
//         while(curr2!=null){
//             length2++;
//             curr2=curr2.next;
//         }
//         curr1=l1; curr2=l2;
//         int sum=0;
//      //   int carry=0;
//         while(curr1!=null&&curr2!=null){
//             if(length1>length2){
//                 sum=sum+curr1.val+carry;
//                 length1--;
//                 curr1=curr1.next;
//             }
//             else{
//                 sum=sum+curr1.val+curr2.val+carry;
//                 curr1=curr1.next;
//                 curr2=curr2.next;
//             }
//             curr3.next=new ListNode(sum%10);
//                 carry=sum/10;
//                 curr3=curr3.next;

//         }
//         return dummy.next;
//     }
// }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
ListNode reversedL1 = reverseList(l1);
        ListNode reversedL2 = reverseList(l2);
        
        // Step 2: Add the reversed lists
        ListNode sumReversed = addReversedLists(reversedL1, reversedL2);
        
        // Step 3: Reverse the result to get the final result
        return reverseList(sumReversed);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    private ListNode addReversedLists(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
}
