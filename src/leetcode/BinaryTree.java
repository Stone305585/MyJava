package leetcode;

import java.util.*;

/**
 * Created by zhaohe on 2016/7/10.
 * 所有关于二叉树的算法
 * 前序
 * 中序
 * 后序
 * 根据前序和中序构建二叉树
 */
public class BinaryTree {
    /**
     * 二叉树结点
     */
    static class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getVal() {
            return val;
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.getVal());
        inOrder(root.right);
    }

    /**
     * 后序遍历
     */
    public void afterOrder(Node root) {
        if (root == null)
            return;
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.val);
    }

    //------------------------根据前中序遍历构建二叉树------------------------

    /**
     * 在a中找出x值的位置
     *
     * @param a
     * @param x
     * @param begin
     * @param end
     * @return
     */
    public static int findIndexInArray(int[] a, int x, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (x == a[i])
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] preOrder = {7,10,4,3,2,8};
        int[] inOrder = {4,10,3,7,8,2};

        buildTreeByPreOrderInOrder(preOrder, 0, 5, inOrder, 0, 5);
    }

    /**
     * int[] preOrder = {7,10,4,3,1,2,8,11};
     * int[] inOrder = {4,10,3,1,7,11,8,2};
     * 构建二叉树！
     *
     * @param preOrder 前序
     * @param preBegin
     * @param preEnd
     * @param inOrder  中序
     * @param inBegin
     * @param inEnd
     * @return
     */
    public static Node buildTreeByPreOrderInOrder(int[] preOrder, int preBegin, int preEnd, int[] inOrder, int inBegin, int inEnd) {
        if (preBegin > preEnd || inBegin > inEnd)
            return null;
        if (preOrder == null || inOrder == null)
            return null;
        //找到第一个根节点
        int rootVal = preOrder[preBegin];

        if(preBegin == preEnd && inBegin == inEnd) {
            return new Node(preOrder[preBegin]);
        }
        Node root = new Node(rootVal);
        //找到中序遍历的中的该节点，从而区分左右二叉树
        int rootIndex = findIndexInArray(inOrder, rootVal, inBegin, inEnd);

        //递归构建二叉树，明白一件事，不管前中后遍历，去掉根节点后分开的子序列，分别为其左右二叉树的前中后序遍历！
        root.left = buildTreeByPreOrderInOrder(preOrder, preBegin + 1, preBegin + rootIndex - inBegin, inOrder, inBegin, inBegin + rootIndex - inBegin - 1);
        root.right = buildTreeByPreOrderInOrder(preOrder, preBegin + rootIndex - inBegin + 1, preEnd, inOrder, rootIndex + 1, inEnd);

        return root;
    }

    /**
     * 求取二叉树深度。
     *
     * @param root
     * @return
     */
    private int treeDeep(Node root) {
        if (root == null) {
            return 0;
        }
        return treeDeep(root.left) > treeDeep(root.right) ? treeDeep(root.left) + 1 : treeDeep(root.right) + 1;
    }

    /**
     * 证明二叉树是平衡树。
     *
     * @param root
     * @param length
     * @return
     */
    private boolean isBalance(Node root, Integer length) {
        if (root == null) {
            length = 0;
            return true;
        }

        Integer left = 0;
        Integer right = 0;

        //根据后续遍历的思想，每次首先遍历左右节点，就能得出该子树是不是平衡树。
        if (isBalance(root.left, left) && isBalance(root.right, right)) {
            int diff = left - right;

            if (diff >= -1 && diff <= 1) {
                length = 1 + left > right ? left : right;
                return true;
            }
        }
        return false;
    }


    /**
     * 结合宽度遍历 倒序输出 二叉树每一层
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(Node root) {

        if (root == null) {
            return null;
        }
        Stack<List> stack = new Stack<List>();
        Queue<Node> queue = new LinkedList<Node>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            //这一步很关键，用于区分当前层与下一层。
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            stack.push(list);

        }

        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        while (!stack.isEmpty()) {
            lists.add(stack.pop());
        }

        return lists;
    }


    //----------------------对称二叉树--------------------------
    public boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return checkSym(root.left, root.right);
    }

    public boolean checkSym(Node left, Node right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val) {
            return false;
        }

        return checkSym(left.left, right.right) && checkSym(left.right, right.left);
    }
    //----------------------对称二叉树--------------------------

    //--------------------平衡二叉树  左右子树的高度差不超过1-----------------

    /**
     * 获取树的高度
     *
     * @param root
     * @return
     */
    private int getTreeHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
    }

    private boolean isBalance(Node root) {
        if (root == null) {
            return true;
        }

        return Math.abs(getTreeHeight(root.left) - getTreeHeight(root.right)) <= 1 && isBalance(root.left) && isBalance(root.right);
    }
    //--------------------平衡二叉树  左右子树的高度差不超过1-----------------


    /**
     * 从根节点到叶节点，找到和为sum的路径
     *
     * @param root
     * @param sum
     * @return
     */
    private boolean hasPathSum(Node root, int sum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    /**
     * 树的最短路径
     * 1
     * /\
     * 2  3
     * /   /\
     * 4   5  6
     * /\ /\
     *
     * @param root 7 8 9 0  这个树最短是3，  1-2-4
     * @return
     */
    public int minDepth(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }

        //这个是错的/。。。。
//        if(root.left == null && root.right == null) {
//            return 1;
//        } else  {
//            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
//        }
    }

    /**
     * 二叉树所有路径 从根节点到叶节点
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(Node root) {
        ArrayList<String> result = new ArrayList<String>();
        if (root == null)
            return result;
        dfs("", root, result);
        return result;
    }

    public void dfs(String path, Node root, ArrayList<String> pathList) {
        if (root.left == null && root.right == null) {
            path += root.val;
            pathList.add(path);
            return;
        }

        path = path + "" + root.val + "->";

        if (root.left != null) {
            dfs(path, root.left, pathList);
        }
        if (root.right != null) {
            dfs(path, root.right, pathList);
        }
    }

}
