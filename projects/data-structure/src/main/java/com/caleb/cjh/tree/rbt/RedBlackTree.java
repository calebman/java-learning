package com.caleb.cjh.tree.rbt;

import com.caleb.cjh.tree.rbt.RedBlackTreeNode;

public class RedBlackTree {

    private RedBlackTreeNode root;    // 根结点
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RedBlackTree() {
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

    private RedBlackTreeNode parentOf(RedBlackTreeNode node) {
        return node != null ? node.parent : null;
    }

    private boolean colorOf(RedBlackTreeNode node) {
        return node != null ? node.color : BLACK;
    }

    private boolean isRed(RedBlackTreeNode node) {
        return ((node != null) && (node.color == RED)) ? true : false;
    }

    private boolean isBlack(RedBlackTreeNode node) {
        return !isRed(node);
    }

    private void setBlack(RedBlackTreeNode node) {
        if (node != null) {
            node.color = BLACK;
        }
    }

    private void setRed(RedBlackTreeNode node) {
        if (node != null) {
            node.color = RED;
        }
    }

    private void setParent(RedBlackTreeNode node, RedBlackTreeNode parent) {
        if (node != null) {
            node.parent = parent;
        }
    }

    private void setColor(RedBlackTreeNode node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    /**
     * (递归实现)查找对应值的节点
     *
     * @param num 查找索引值
     * @return 节点对象
     */
    private RedBlackTreeNode search(RedBlackTreeNode x, int num) {
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

    public RedBlackTreeNode search(int num) {
        return search(root, num);
    }

    /**
     * (非递归实现)查找对应值的节点
     *
     * @param num 查找索引值
     * @return 节点对象
     */
    public RedBlackTreeNode iterativeSearch(int num) {
        RedBlackTreeNode x = root;
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
    public RedBlackTreeNode minimum() {
        RedBlackTreeNode x = root;
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
    public RedBlackTreeNode maximum() {
        RedBlackTreeNode x = root;
        if (x == null) {
            return x;
        }

        while (x.right != null) {
            x = x.right;
        }

        return x;
    }

    /*
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                              px
     *     /                               /
     *    x                               y
     *   /  \      --(左旋)-.           / \                #
     *  lx   y                          x  ry
     *     /   \                       /  \
     *    ly   ry                     lx  ly
     *
     *
     */
    private void leftRotate(RedBlackTreeNode x) {
        // 设置x的右孩子为y
        RedBlackTreeNode y = x.right;

        // 将 “y的左孩子” 设为 “x的右孩子”；
        // 如果y的左孩子非空，将 “x” 设为 “y的左孩子的父亲”
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        // 将 “x的父亲” 设为 “y的父亲”
        y.parent = x.parent;

        if (x.parent == null) {
            this.root = y;            // 如果 “x的父亲” 是空节点，则将y设为根节点
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
            } else {
                x.parent.right = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
            }
        }

        // 将 “x” 设为 “y的左孩子”
        y.left = x;
        // 将 “x的父节点” 设为 “y”
        x.parent = y;
    }

    /*
     * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                               py
     *           /                                /
     *          y                                x
     *         /  \      --(右旋)-.            /  \                     #
     *        x   ry                           lx   y
     *       / \                                   / \                   #
     *      lx  rx                                rx  ry
     *
     */
    private void rightRotate(RedBlackTreeNode y) {
        // 设置x是当前节点的左孩子。
        RedBlackTreeNode x = y.left;

        // 将 “x的右孩子” 设为 “y的左孩子”；
        // 如果"x的右孩子"不为空的话，将 “y” 设为 “x的右孩子的父亲”
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        // 将 “y的父亲” 设为 “x的父亲”
        x.parent = y.parent;

        if (y.parent == null) {
            this.root = x;            // 如果 “y的父亲” 是空节点，则将x设为根节点
        } else {
            if (y == y.parent.right) {
                y.parent.right = x;    // 如果 y是它父节点的右孩子，则将x设为“y的父节点的右孩子”
            } else {
                y.parent.left = x;    // (y是它父节点的左孩子) 将x设为“x的父节点的左孩子”
            }
        }

        // 将 “y” 设为 “x的右孩子”
        x.right = y;

        // 将 “y的父节点” 设为 “x”
        y.parent = x;
    }

    /*
     * 红黑树插入修正函数
     *
     * 在向红黑树中插入节点之后(失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     *
     * 参数说明：
     *     node 插入的结点        // 对应《算法导论》中的z
     */
    private void insertFixUp(RedBlackTreeNode node) {
        RedBlackTreeNode parent, gparent;

        // 若“父节点存在，并且父节点的颜色是红色”
        while (((parent = parentOf(node)) != null) && isRed(parent)) {
            gparent = parentOf(parent);

            //若“父节点”是“祖父节点的左孩子”
            if (parent == gparent.left) {
                // Case 1条件：叔叔节点是红色
                RedBlackTreeNode uncle = gparent.right;
                if ((uncle != null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                // Case 2条件：叔叔是黑色，且当前节点是右孩子
                if (parent.right == node) {
                    RedBlackTreeNode tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是左孩子。
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {    //若“z的父节点”是“z的祖父节点的右孩子”
                // Case 1条件：叔叔节点是红色
                RedBlackTreeNode uncle = gparent.left;
                if ((uncle != null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                // Case 2条件：叔叔是黑色，且当前节点是左孩子
                if (parent.left == node) {
                    RedBlackTreeNode tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是右孩子。
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }

        // 将根节点设为黑色
        setBlack(this.root);
    }


    /**
     * 插入节点
     *
     * @param num 索引值
     */
    public void insert(int num) {
        RedBlackTreeNode node = new RedBlackTreeNode(num, BLACK, null, null, null);

        int cmp;
        RedBlackTreeNode y = null;
        RedBlackTreeNode x = this.root;

        // 1. 将红黑树当作一颗二叉查找树，将节点添加到二叉查找树中。
        while (x != null) {
            y = x;
            cmp = num - x.getNum();
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y != null) {
            cmp = num - y.getNum();
            if (cmp < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        } else {
            this.root = node;
        }

        // 2. 设置节点的颜色为红色
        node.color = RED;

        // 3. 将它重新修正为一颗二叉查找树
        insertFixUp(node);
    }


    /*
     * 销毁红黑树
     */
    private void destroy(RedBlackTreeNode tree) {
        if (tree == null) {
            return;
        }

        if (tree.left != null) {
            destroy(tree.left);
        }
        if (tree.right != null) {
            destroy(tree.right);
        }

        tree = null;
    }

    public void clear() {
        destroy(root);
        root = null;
    }

    /*
     * 打印"红黑树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(RedBlackTreeNode node, int num, int direction) {

        if (node != null) {

            if (direction == 0) {   // tree是根节点
                System.out.printf("%2d(B) is root\n", node.getNum());
            } else {             // tree是分支节点
                System.out.printf("%2d(%s) is %2d's %6s child\n", node.getNum(), isRed(node) ? "R" : "B", num, direction == 1 ? "right" : "left");
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
