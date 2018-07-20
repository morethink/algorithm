package algorithm.swordtooffer;

/**
 * @author 李文浩
 * @version 2017/7/29.
 * <p>
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */


import java.util.ArrayList;

public class Test5 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(new Test5().printListFromTailToHead(listNode));
    }

    /**
     * 解决问题有两种方法
     * 1. 翻转链表
     * 2. 将链表的值存储之后在翻转
     *
     * 查看别人发现，还可使用递归，其实你应该明白凡是跟栈相关的都可通过递归实现
     * @param listNode
     * @return
     */
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        Stack<Integer> stack = new Stack<>();
//        while (listNode != null) {
//            stack.push(listNode.val);
//            listNode = listNode.next;
//
//        }
//        ArrayList arrayList = new ArrayList();
//        while (!stack.isEmpty()) {
//            arrayList.add(stack.pop());
//        }
//        System.out.println(arrayList);
//        return arrayList;
//    }

    /**
     * 递归版本
     *
     * @param listNode
     * @return
     */

    private ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return arrayList;
        } else {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
