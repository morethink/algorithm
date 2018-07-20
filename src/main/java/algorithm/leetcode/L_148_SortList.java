package algorithm.leetcode;

/**
 * @author 李文浩
 * @date 2018/2/16
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class L_148_SortList {

    public static void main(String[] args) {

        ListNode head = new ListNode(12);
//        head = addBack(head, 3);
//        head = addBack(head, 10);
//        head = addBack(head, 25);
//        head = addBack(head, 12);
//        head = addBack(head, 5);
//        head = addBack(head, 55);
//        head = addBack(head, 55);

//        for (int i = 0; i < 10; i++)
//            head = addBack(head, (int) (Math.random() * 100));
        System.out.print("排序前:");
        print(head);

//        head = new L_148_SortList().sortList(head);

        head = new L_147_InsertionSortList().insertionSortList(head);
        System.out.print("排序后:");
        print(head);
    }
    public static ListNode addBack(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = null;
        ListNode node = head;
        if (head == null) {
            head = newNode;
            return head;
        }
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;

        return head;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    public static ListNode partion(ListNode head, ListNode end) {
        ListNode p1 = head, p2 = head.next;

        //走到末尾才停
        while (p2 != end) {

            //大于key值时，p1向前走一步，交换p1与p2的值
            if (p2.val < head.val) {
                p1 = p1.next;

                int temp = p1.val;
                p1.val = p2.val;
                p2.val = temp;
            }
            p2 = p2.next;
        }

        //当有序时，不交换p1和key值
        if (p1 != head) {
            int temp = p1.val;
            p1.val = head.val;
            head.val = temp;
        }
        return p1;
    }


    public ListNode sortList(ListNode head) {
        //采用快速排序
//        quickSort(head, null);
//        return head;

        //采用归并排序
        if (head == null || head.next == null) {
            return head;
        }
        //获取中间结点
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        //合并
        return mergeSort(sortList(head), sortList(right));
    }

    /**
     * 获取链表的中间结点,偶数时取中间第一个
     *
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode slow = head, quick = head;
        //快2步，慢一步
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    /**
     *
     * 归并两个有序的链表
     *
     * @param head1
     * @param head2
     * @return
     */
    private ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2, head;
       //得到头节点的指向
        if (head1.val < head2.val) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }

        ListNode p = head;
        //比较链表中的值
        while (p1 != null && p2 != null) {

            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        //第二条链表空了
        if (p1 != null) {
            p.next = p1;
        }
        //第一条链表空了
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }
}
