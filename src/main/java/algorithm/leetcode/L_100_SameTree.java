package algorithm.leetcode;

/**
 * @author 李文浩
 * @date 2018/7/3
 */
public class L_100_SameTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) {
            return true;
        } else if (q != null && p != null) {
            if (p.val != q.val) {
                return false;
            } else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        } else {
            return false;
        }
    }

}
