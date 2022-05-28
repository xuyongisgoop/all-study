package com.xuyong.study.aogrithum;

/**
 * Created by xuyong on 2021/11/19
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pre_start = 0;
        int pre_end = preorder.length;
        int in_start = 0;
        int in_end = inorder.length;
        return generateTree(preorder, pre_start, pre_end, inorder, in_start, in_end);
    }

    private TreeNode generateTree(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        if (pre_start == pre_end) {
            return null;
        }
        // 创建一个节点
        TreeNode newNode = new TreeNode(preorder[pre_start]);
        // 找到在中序遍历中根节点的位置
        int in_index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[pre_start]) {
                in_index = i;
                break;
            }
        }
        int leftNum = in_index - in_start;
        // 生成左子树
        newNode.left = generateTree(preorder, pre_start + 1, pre_start + leftNum + 1, inorder, in_start, in_index);
        // 生成右子树
        newNode.right = generateTree(preorder, pre_start + leftNum + 1, pre_end, inorder, in_index + 1, in_end);
        return newNode;
    }

}
