package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 李文浩
 * @date 2018/2/24
 */
public class L_94_BinaryTreeInorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        List<Integer> list = new L_94_BinaryTreeInorderTraversal().inorderTraversal(treeNode1);

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        //左子树全部入栈
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        //将弹出节点和弹出节点的左子树入栈
        while (!stack.empty()) {
            node = stack.pop();
            list.add(node.val);
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

        }


        return list;
    }
}
