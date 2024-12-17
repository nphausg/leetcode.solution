package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree">111. Minimum Depth of Binary Tree</a>
 */
public class MinimumDepthOfBinaryTree {

    // DFS: Top-Down
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // DFS: Top-Down
    public int minDepthDFSEarlyStop(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth, minDepthDFSEarlyStop(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth, minDepthDFSEarlyStop(root.left));
        }
        return minDepth + 1;
    }

    // BFS: Bottom-up
    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }

        return depth;
    }
}
