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
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        helper(root);

        return max;
    }

    void helper(TreeNode node){
        if(node == null)
            return;

        if(isBST(node, null, null)){
            int count = count(node);
            if(count>max)
                max = count;
        }

        helper(node.left);
        helper(node.right);
    }

    int count(TreeNode node){
        if(node == null)
            return 0;

        return 1 + count(node.left) + count(node.right);
    }

     boolean isBST(TreeNode node, Integer left, Integer right){

        if(node == null)
            return true;

        if (left != null && node.val <= left) return false;
        if (right != null && node.val >= right) return false;

        return isBST(node.left, left, node.val) && isBST(node.right, node.val, right);
    }
}
