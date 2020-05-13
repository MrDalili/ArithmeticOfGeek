package 第03课数组链表跳表.实战题目;

/**
 * singly 各个的
 * iteratively /'itə,reitivli/  迭代
 * recursively /ri'kəsivli/ 递归
 */

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;

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
public class ReverseList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode node1 = reverseList(node);
        System.out.println(node1);
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {
//        //先进行边界运算
//        if (head == null)
//            return null;
//        return reverse(head).get(0);
        return reversListInt(head,null);
    }

    /**
     * genius solution
     * @param head
     * @return
     */
    public static ListNode reversListInt(ListNode head ,ListNode newHead){
        if (head == null){
            return newHead;
        }
        ListNode newNode = head.next;
        head.next = newHead;
        return reversListInt(newNode,head);
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


    //这个效率是最几把低的，时间负责度是n²
//    public ListNode reverseList(ListNode head) {
//        //先判断一个是不是空的
//        if (head == null)
//            return null;
//        /**
//         * 使用递归，先传入首节点，然后把首节点拿出来，把首节点放在最后面就行了。
//         */
//        if (head.next == null){
//            //那么这就是最后一个节点
//            return head;
//        }
//        //把首节点拿出来
//        ListNode myHead = new ListNode(head.val);
//        //这里先递归，把后面的先拿出来，然后把现在的加到最后面去了
//
//        //感觉是可以优化的，因为每次进入一个新的节点我都要重新从1开始遍历
//        //如果我每次把最后一个节点和新的节点传出来的话就好多了
//
//        return appendNode(reverseList(head.next),myHead);
//    }

    /**
     * 传入旧节点和新节点，把新节点加在就节点的最后一个屁股上
     * @param oldNode
     * @param newNode
     * @return
     */
//    public static ListNode appendNode(ListNode oldNode , ListNode newNode){
//        ListNode myNode = oldNode;
//        while (myNode.next != null){
//            myNode = myNode.next;
//        }
//        myNode.next = newNode;
//        return oldNode;
//    }
}
