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
        //先进行边界运算
        if (head == null)
            return null;
        return reverse(head).get(0);
    }

    public static List<ListNode> reverse(ListNode head) {

        //出口，当没有下一个元素额时候
        if (head.next == null){
            return Arrays.asList(head,head);
        }
        //先把当前的元素拿出来，这个元素现在看起来是第一个，但是起使它是最后一个，因为要颠倒你知道吗
//        ListNode lastNode = head;
//        lastNode.next = null;
        ListNode lastNode = new ListNode(head.val);
        //把需要改的传进去，第一个存放的是首节点，第二个存放的是倒数节点
        List<ListNode> myResult = reverse(head.next);
        //看看是不是最后一个节点
        //不是的话，那么第二个就会是最后一个节点
        myResult.get(1).next = lastNode;
        return Arrays.asList(myResult.get(0),lastNode);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
