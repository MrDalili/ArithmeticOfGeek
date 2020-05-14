//Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both? 
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)
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

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * Related Topics
 * Linked List
 */
class Solution {
    public static ListNode reverseList(ListNode head) {
//        //先进行边界运算
//        if (head == null)
//            return null;
//        return reverse(head).get(0);
        //return reversListIntRecursion(head,null);
        return reversListIntIteration(head,null);
    }

    public static ListNode reversListIntIteration(ListNode head ,ListNode newHead){
        while (true){
            if (head == null){
                break;
            }
            ListNode newList = head.next;
            head.next = newHead;
            newHead = head;
            head = newList;
        }
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
