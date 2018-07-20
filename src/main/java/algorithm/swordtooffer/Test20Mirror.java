package algorithm.swordtooffer;

import algorithm.tree.BinaryTree;
import algorithm.tree.TreeNode;

/**
 * @author 李文浩
 * @date 2018/7/6
 */
public class Test20Mirror {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode root2 = new TreeNode(8);
        TreeNode root3 = new TreeNode(7);
        TreeNode root4 = new TreeNode(9);
        TreeNode root5 = new TreeNode(2);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        BinaryTree.inOrder(root1);
        new Test20Mirror().Mirror(root1);
        System.out.println();
        BinaryTree.inOrder(root1);
        
    }


    public void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            Mirror(root.left);
            Mirror(root.right);

        }
    }
}
