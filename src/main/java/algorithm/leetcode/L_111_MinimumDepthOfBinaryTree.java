package algorithm.leetcode;


/**
 * Given a binary tree, find its minimum depth.The minimum depth is the number
 * of roots along the shortest path from the root root down to the nearest leaf root.
 * <p>
 * 思路：
 * 递归，若为空树返回0；
 * 若左子树为空，则返回右子树的最小深度+1；（加1是因为要加上根这一层，下同）
 * 若右子树为空，则返回左子树的最小深度+1；
 * 若左右子树均不为空，则取左、右子树最小深度的较小值，+1；
 *
 * @author 李文浩
 * @date 2018/2/12
 */
public class L_111_MinimumDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        object = 10;
        System.out.println(object);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left, right = root.right;
        if (left == null && right == null) {
            return 1;
        }
        if (left == null && right != null) {
            return minDepth(right) + 1;
        }
        if (right == null && left != null) {
            return minDepth(left) + 1;
        }
        int leftHeight = minDepth(left);
        int rightHeight = minDepth(right);
        return leftHeight < rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
}
