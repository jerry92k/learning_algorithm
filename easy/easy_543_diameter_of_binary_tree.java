/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
/**
 * 각 루트에서 양쪽의 길이 차를 계산하고 차가 가장 큰 경우를 longest length로 한다.
 */
class Solution {

    private int maxLen = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        int sumLen = 2 + traversal(root.left) + traversal(root.right);
        if (getMaxLen() < sumLen) {
            return sumLen;
        }
        return getMaxLen();

    }

    public int getMaxLen() {
        return this.maxLen;
    }

    public void setMaxLen(int maxLen) {
        this.maxLen = maxLen;
    }

    public int traversal(TreeNode root) {

        if (root == null) {
            return -1;
        }
        int leftLen = 1 + traversal(root.left);
        int rightLen = 1 + traversal(root.right);

        int sumLen = leftLen + rightLen;
        if (getMaxLen() < leftLen + rightLen) {
            setMaxLen(sumLen);
        }

        if (leftLen >= rightLen) {
            return leftLen;
        } else {
            return rightLen;
        }
    }
}