package com.caleb.structure.tree.rbt;

/**
 * 红黑树节点结构
 */
public class RedBlackTreeNode {
    int num;
    public boolean color;
    public RedBlackTreeNode left;
    public RedBlackTreeNode right;
    public RedBlackTreeNode parent;

    public RedBlackTreeNode(int num, boolean color, RedBlackTreeNode left, RedBlackTreeNode right, RedBlackTreeNode parent) {
        this.num = num;
        this.color = color;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public int compareTo(int num) {
        return num - this.num;
    }

    public int getNum() {
        return num;
    }

    /*
     * 前序遍历"二叉树节点"
     */
    private void preOrder(RedBlackTreeNode node) {
        if (node != null) {
            System.out.print(node.getNum() + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void preOrder() {
        preOrder(this);
    }

    /*
     * 中序遍历"二叉树"
     */
    private void inOrder(RedBlackTreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.getNum() + " ");
            inOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(this);
    }


    /*
     * 后序遍历"二叉树"
     */
    private void postOrder(RedBlackTreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.getNum() + " ");
        }
    }

    public void postOrder() {
        postOrder(this);
    }
}
