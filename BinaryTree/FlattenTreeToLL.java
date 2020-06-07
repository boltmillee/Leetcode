/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }

    TreeNode helper(TreeNode node){

        if(node == null)
            return null;

        if(node.left == null && node.right == null)
            return node;

        TreeNode leftTail = helper(node.left);

        TreeNode rightTail = helper(node.right);

        if(leftTail != null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        //if right tail is null that means the last node is left tail so we return that
        return rightTail == null ? leftTail: rightTail;
    }
}
//[1,2,5,3,4,null,6]
