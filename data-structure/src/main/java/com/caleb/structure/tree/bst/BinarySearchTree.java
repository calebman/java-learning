package com.caleb.structure.tree.bst;

import com.caleb.structure.tree.BinarySearchTreeInterface;

/**
 * @author calebman
 * @Date 2018-05-25
 * <p>
 * 实现一个二叉查找树
 * </p>
 */
public class BinarySearchTree implements BinarySearchTreeInterface {

    // 根节点
    private BinaryTreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void preOrder() {
        root.preOrder();
    }

    public void inOrder() {
        root.inOrder();
    }

    public void postOrder() {
        root.postOrder();
    }

    /**
     * (递归实现)查找对应值的节点
     *
     * @param num 查找索引值
     * @return 节点对象
     */
    private BinaryTreeNode search(BinaryTreeNode x, int num) {
        if (x == null) {
            return x;
        }

        int cmp = num - x.getNum();
        if (cmp < 0) {
            return search(x.left, num);
        } else if (cmp > 0) {
            return search(x.right, num);
        } else {
            return x;
        }
    }

    public BinaryTreeNode search(int num) {
        return search(root, num);
    }

    /**
     * (非递归实现)查找对应值的节点
     *
     * @param num 查找索引值
     * @return 节点对象
     */
    public BinaryTreeNode iterativeSearch(int num) {
        BinaryTreeNode x = root;
        while (x != null) {
            int cmp = num - x.getNum();

            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }
        return x;
    }

    /**
     * 寻找最小节点
     *
     * @return 节点对象
     */
    public BinaryTreeNode minimum() {
        BinaryTreeNode x = root;
        if (x == null) {
            return x;
        }

        while (x.left != null) {
            x = x.left;
        }

        return x;
    }

    /**
     * 寻找最大节点
     *
     * @return 节点对象
     */
    public BinaryTreeNode maximum() {
        BinaryTreeNode x = root;
        if (x == null) {
            return x;
        }

        while (x.right != null) {
            x = x.right;
        }

        return x;
    }

    /**
     * 插入节点
     *
     * @param num 索引值
     */

    public void insert(int num) {
        BinaryTreeNode insertNode = new BinaryTreeNode(num, null, null, null);

        int cmp;
        BinaryTreeNode y = null;
        BinaryTreeNode x = root;

        // 查找z的插入位置
        while (x != null) {
            y = x;
            cmp = num - x.getNum();
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        insertNode.parent = y;
        if (y == null) {
            root = insertNode;
        } else {
            cmp = num - y.getNum();
            if (cmp < 0) {
                y.left = insertNode;
            } else {
                y.right = insertNode;
            }
        }
    }

    /*
     * 打印"二叉查找树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(BinaryTreeNode node, int num, int direction) {

        if (node != null) {

            if (direction == 0) {   // tree是根节点
                System.out.printf("%2d is root\n", node.getNum());
            } else {        // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", node.getNum(), num, direction == 1 ? "right" : "left");
            }

            print(node.left, node.getNum(), -1);
            print(node.right, node.getNum(), 1);
        }
    }

    public void print() {
        if (root != null) {
            print(root, root.getNum(), 0);
        }
    }
}
