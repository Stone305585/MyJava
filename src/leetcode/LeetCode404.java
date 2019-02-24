package leetcode;

/**
 * Created by ASUS on 2016/10/19.
 */
public class LeetCode404 {

    public int sumOfLeftLeaves(BinaryTree.Node root) {

        return getLeftSum(root, true);
    }

    public int getLeftSum(BinaryTree.Node root, boolean isLeft) {
        if(root.left == null && root.right == null) {
            if(isLeft) {
                return root.val;
            }
        } else if (root.left != null && root.right == null){
            return getLeftSum(root.left, true);
        } else if (root.right != null && root.left == null) {
            return getLeftSum(root.right, false);
        } else
        return getLeftSum(root.right, false) + getLeftSum(root.left, true);

        return 0;
    }
}
