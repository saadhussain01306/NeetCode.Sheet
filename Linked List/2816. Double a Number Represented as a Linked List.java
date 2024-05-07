/*
You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.

 

Example 1:


Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
Example 2:


Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
 

Constraints:

The number of nodes in the list is in the range [1, 104]
0 <= Node.val <= 9
The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.
*/

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
    public ListNode doubleIt(ListNode head) {
        if (head == null) {
            return null;
        }

        // Reverse the linked list
        ListNode reversedHead = reverseLinkedList(head);

        // Double the reversed linked list
        ListNode doubledHead = doubleList(reversedHead);

        // Reverse the doubly linked list again to get the final result
        return reverseLinkedList(doubledHead);   
    }

     private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    private ListNode doubleList(ListNode head) {
        ListNode current = head;
        int carry = 0;

        while (current != null) {
            int doubledValue = current.val * 2 + carry;
            current.val = doubledValue % 10;
            carry = doubledValue / 10;

            if (current.next == null && carry > 0) {
                // If we have a carry after processing the last node, create a new node
                current.next = new ListNode(carry);
                break;
            }

            current = current.next;
        }

        return head;
    }
}
