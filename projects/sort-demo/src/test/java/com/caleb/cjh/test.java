package com.caleb.cjh;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


    static void generatorNodes(int[] nums, int left, Node parentNode) {
        int len = nums.length;
        for (int i = left; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    Node node = new Node(nums[j] - nums[i]);
                    generatorNodes(nums, j + 1, node);
                    parentNode.addChildNode(node);
                }
            }
        }
    }

    public static class Node<T> implements Serializable {

        private Node parentNode;
        private T nodeEntity;
        private List<Node> childNodes;

        public Node(T nodeEntity) {
            this.nodeEntity = nodeEntity;
        }

        public void addChildNode(Node childNode) {
            childNode.setParentNode(this);
            if (this.childNodes == null) {
                this.childNodes = new ArrayList<Node>();
            }
            this.childNodes.add(childNode);
        }


        public void setParentNode(Node parentNode) {
            this.parentNode = parentNode;
        }

        public T getNodeEntity() {
            return nodeEntity;
        }

        public List<Node> getChildNodes() {
            return childNodes;
        }
    }

    static int max = 0;

    public static void computeNode(Node<Integer> node, int score) {
        score += node.getNodeEntity();
        if (node.getChildNodes() == null) {
            if (score > max) {
                max = score;
            }
        } else {
            for (Node<Integer> childNode : node.getChildNodes()) {
                computeNode(childNode, score);
            }
        }
    }
}
