/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        if(root.left == null && root.right == null )
            return true;

       return helper(root, null, null);
    }

     boolean helper(TreeNode node, Integer left, Integer right){

        if(node == null)
            return true;

        if (left != null && node.val <= left) return false;
        if (right != null && node.val >= right) return false;

        return helper(node.left, left, node.val) && helper(node.right, node.val, right);
    }
}
