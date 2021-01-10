package com.caleb.structure.tree.bst;

/**
 * 二叉树节点数据结构
 */
public class BinaryTreeNode {
    int num;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode parent;

    public BinaryTreeNode(int num, BinaryTreeNode left, BinaryTreeNode right, BinaryTreeNode parent) {
        this.num = num;
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
    private void preOrder(BinaryTreeNode node) {
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
    private void inOrder(BinaryTreeNode node) {
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
    private void postOrder(BinaryTreeNode node) {
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