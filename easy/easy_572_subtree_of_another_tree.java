/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

/*
 * [전략] 1. 재귀적으로 트리를 순회하며 subRoot의 루트값과 같은 node를 찾는다. 2. 찾은 노드부터 시작하여 subRoot의
 * 모양을 그리는지 재귀적으로 확인한다.
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        return traversal(root, subRoot);
    }

    public boolean traversal(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (checkSubtree(root.left, subRoot.left) && checkSubtree(root.right, subRoot.right)) {
                return true;
            }
        }
        return traversal(root.left, subRoot) || traversal(root.right, subRoot);

    }

    public boolean checkSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        } else if (root == null && subRoot != null) {
            return false;
        } else if (root != null && subRoot == null) {
            return false;
        } else {
            if (root.val == subRoot.val) {
                if (checkSubtree(root.left, subRoot.left) && checkSubtree(root.right, subRoot.right)) {
                    return true;
                }
            }
            return false;
        }
    }
}