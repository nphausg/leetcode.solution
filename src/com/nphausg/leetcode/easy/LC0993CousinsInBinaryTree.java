package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.utils.TreeNode;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
/**
 * <a href="https://leetcode.com/problems/cousins-in-binary-tree">993. Cousins in Binary Tree</a>
 */

public class LC0993CousinsInBinaryTree {
    public boolean isCousinsBFS(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            boolean isXFound = false, isYFound = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == x) {
                    isXFound = true;
                }
                if (node.val == y) {
                    isYFound = true;
                }
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                            (node.left.val == y && node.right.val == x)) {
                        // Same parent
                        return false;
                    }
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (isXFound && isYFound)
                return true;
            if (isXFound || isYFound)
                return false;
        }
        return false;
    }

    int xDepth = 0, yDepth = 0;
    TreeNode xParent, yParent;

    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
        if (root == null)
            return;
        if (root.val == x) {
            xDepth = depth;
            xParent = parent;
        } else if (root.val == y) {
            yDepth = depth;
            yParent = parent;
        }
        dfs(root.left, parent, depth + 1, x, y);
        dfs(root.right, parent, depth + 1, x, y);
    }

    public boolean isCousinsDFS(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return xDepth == yDepth && xParent != yParent;
    }

}
