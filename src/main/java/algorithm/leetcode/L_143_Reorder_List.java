package algorithm.leetcode;

/**
 * @author 李文浩
 * @date 2018/3/15
 */
public class L_143_Reorder_List {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        for (int i = 2; i < 9; i++)
            head = addBack(head, i);
        System.out.print("reorder前:");
        print(head);
        System.out.print("reorder后:");
        new L_143_Reorder_List().reorderList(head);
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


    /**
     * 通过快慢指针找到中间节点，拆分链表为两部分，将后半部分链表翻转，然后合并两部分
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //快慢指针找到中间节点
        ListNode slow = head, fast = head, temp = null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //拆分链表为两部分
        temp = slow.next;
        slow.next = null;
        slow = temp;

        //后半边进行头插法，翻转链表
        ListNode node = slow.next;
        slow.next = null;
        while (node != null) {
            temp = node.next;
            node.next = slow;
            slow = node;
            node = temp;

        }
        //合并链表
        merge(head, slow);
    }

    public void merge(ListNode head1, ListNode head2) {
        ListNode p = head1, q = head2, temp;
        while (p != null && q != null) {
            temp = p.next;
            p.next = q;
            p = temp;
            temp = q.next;
            q.next = p;
            q = temp;

        }
    }

    /**
     * 暴力法，找到Ln节点，然后移动到L1和L2之间，以此类推
     *
     * @param head
     */
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode p1 = head, p2 = head.next, node1 = p1, node2 = p2;

        while (p2 != null && p2.next != null) {

            //找到Ln
            while (node2.next != null) {
                node1 = node2;
                node2 = node2.next;
            }
            //移动Ln到L1和L2中间
            node1.next = null;
            p1.next = node2;
            node2.next = p2;
            //重新更改位置
            p1 = p2;
            p2 = p2.next;
            node2 = p2;
            node1 = p1;
        }
    }
}
