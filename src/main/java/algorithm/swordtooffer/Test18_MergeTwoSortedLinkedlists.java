package algorithm.swordtooffer;

/**
 * @author 李文浩
 * @date 2018/7/2
 */
public class Test18_MergeTwoSortedLinkedlists {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = null, list2 = null;
        for (int i = 1; i < 10; i += 2) {
            list1 = addBack(list1, i);
            //list2 = addBack(list2, i + 1);
        }
        list2 = addBack(list2, 11);
        list2 = addBack(list2, 12);
        list2 = addBack(list2, 13);
        list2 = addBack(list2, 14);

        show(new Test18_MergeTwoSortedLinkedlists().Merge(list1, list2));
        //show(new Test18_MergeTwoSortedLinkedlists().Merge2(list1, list2));
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

    public static void show(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println();
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }


        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }


        return head.next;
    }

}
