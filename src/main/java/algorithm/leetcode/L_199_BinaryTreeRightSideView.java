package algorithm.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 李文浩
 * @date 2018/3/31
 */
public class L_199_BinaryTreeRightSideView {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 因为题目的二叉树并不是满二叉树，所以采用层序遍历的方式。
     * 将以前层序遍历中一个个出队的方式变为一层层出队，
     * 这样就能定位最右边的节点。
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            //将每一层的节点都出队
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (i == 0) {
                    list.add(treeNode.val);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
            }
        }
        return list;
    }
}
