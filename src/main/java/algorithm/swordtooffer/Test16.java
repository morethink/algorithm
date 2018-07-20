package algorithm.swordtooffer;

/**
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 即链表面试题 第三题 list/LinkedList.java
 * @author 李文浩
 * @version 2017/9/10.
 */
public class Test16 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode FindKthToTail(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        ListNode p2 = head, p1 = head;
        while (k-- > 1 && p1 != null) {
            p1 = p1.next;
        }
        // 说明k>size，因此返回null
        if (k > 1 || p1 == null) {
            return null;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
