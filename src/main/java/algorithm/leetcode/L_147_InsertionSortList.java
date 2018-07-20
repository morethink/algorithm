package algorithm.leetcode;

/**
 * @author 李文浩
 * @date 2018/2/21
 */


public class L_147_InsertionSortList {
    /**
     * 新建一个链表，然后遍历原链表按序插入新链表
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode headNext = head.next;
        head.next = null;
        //遍历原链表
        for (ListNode node = headNext, nodeNext = node.next; node != null; node = nodeNext, nodeNext = nodeNext == null ? null : nodeNext.next) {
            ListNode p1 = head, p2 = null;
            //插入新链表
            for (; p1 != null; p2 = p1, p1 = p1.next) {
                if (p1.val > node.val) {
                    //小于头节点
                    if (p1 == head) {
                        head = node;
                        head.next = p1;

                    } else {
                    //在中间
                        p2.next = node;
                        node.next = p1;
                    }
                    break;
                }
            }
            //大于尾节点
            if (p1 == null) {
                p2.next = node;
                node.next = null;
            }
        }


        return head;
    }
}
