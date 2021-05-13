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
    public int diameterOfBinaryTree(TreeNode root) {

        int[] maxLen=new int[1];

        int sumLen = 2+traversal(root.left, maxLen) + traversal(root.right, maxLen);
        if (maxLen[0] < sumLen) {
            return sumLen;
        }
        return maxLen[0];

    }

    public int traversal(TreeNode root, int[] maxLen){

        if (root == null) {
            return -1;
        }
        int leftLen=1+traversal(root.left, maxLen);
        int rightLen=1+traversal(root.right, maxLen);

        int sumLen=leftLen + rightLen;
        if (maxLen[0] < leftLen + rightLen) {
            maxLen[0] = sumLen;
        }

        if (leftLen >= rightLen) {
            return leftLen;
        }
        else{
            return rightLen;
        }
    }
}