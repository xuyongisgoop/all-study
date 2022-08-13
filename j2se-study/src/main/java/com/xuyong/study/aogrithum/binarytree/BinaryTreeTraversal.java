package com.xuyong.study.aogrithum.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 二叉树的前、中、后序遍历
 * @Author: xuyong
 * @Date: 2022/8/3
 **/
public class BinaryTreeTraversal {

    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode5, treeNode4);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode3, treeNode2);
        //List<List<Integer>> integers = levelTraversal(treeNode1);
        int maxDepth = getMaxDepth(treeNode1);
        System.out.println(maxDepth);
    }

    /**
     * @Description: 前中后遍历
     * @Date: 2022/8/3
     * @Param root:
     **/
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        traversal(root, resultList);
        return resultList;
    }

    private static void traversal(TreeNode root, List<Integer> resultList) {
        if (root != null) {
            traversal(root.left, resultList);
            traversal(root.right, resultList);
            resultList.add(root.val);
        }
    }

    /**
     * @Description: 层序遍历
     * @Date: 2022/8/3
     * @Param root:
     **/
    public static List<List<Integer>> levelTraversal(TreeNode root) {
        Deque<List<Integer>> resultList = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList();
        if (root == null) {
            return (List<List<Integer>>)resultList;
        }
        deque.add(root);
        while(!deque.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int currentLevelLen = deque.size();
            for (int i = 0; i < currentLevelLen; i++) {
                TreeNode node = deque.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            resultList.addFirst(levelList);
        }
        return (List<List<Integer>>)resultList;
    }

    public static int getMaxDepth(TreeNode root) {
        return getMax(root, 0);
    }

    public static int getMax(TreeNode root, int level) {
        if (root == null) {
            return level;
        } else {
            return Math.max(getMax(root.left, level + 1), getMax(root.right, level + 1));
        }
    }

}
