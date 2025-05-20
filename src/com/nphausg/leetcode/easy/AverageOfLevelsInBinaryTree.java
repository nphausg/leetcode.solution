package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.utils.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree">637. Average of Levels in Binary Tree</a>
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            long sum = 0;
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(sum / (double) size);
        }
        return result;
    }
}
