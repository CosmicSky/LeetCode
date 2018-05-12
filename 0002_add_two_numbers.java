/*
 * NOTES
 * ListNode represent numbers and do not have to have the same length
 * Make sure to check null for both ListNodes
 * https://leetcode.com/problems/add-two-numbers/solution/
 */

/*
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentl1 = l1;
        ListNode currentl2 = l2;
        boolean carry = false;

        int totalInit = l1.val + l2.val;
        if (totalInit >= 10) {
            totalInit -= 10;
            carry = true;
        }

        ListNode returned = new ListNode(totalInit);
        ListNode currentReturned = returned;
        currentl1 = currentl1.next;
        currentl2 = currentl2.next;

        while (currentl1 != null || currentl2 != null) {
            int val1 = 0;
            if (currentl1 != null) {
                val1 = currentl1.val;
            }
            int val2 = 0;
            if (currentl2 != null) {
                val2 = currentl2.val;
            }
            int total = 0;

            if (carry) {
                total++;
                carry = false;
            }
            total += val1 + val2;
            if (total >= 10) {
                total -= 10;
                carry = true;
            }

            currentReturned.next = new ListNode(total);
            currentReturned = currentReturned.next;
            if (currentl1 != null) {
                currentl1 = currentl1.next;
            }
            if (currentl2 != null) {
                currentl2 = currentl2.next;
            }
        }
        if (carry) {
            currentReturned.next = new ListNode(1);
            return returned;
        }
        return returned;
    }
}