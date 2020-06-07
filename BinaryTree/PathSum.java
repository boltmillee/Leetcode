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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
       return helper(root, sum, 0);
    }

    boolean helper(TreeNode node, int sum, int s){

        if(node == null)
            return false;

        s += node.val;
        if(node.right == null && node.left == null){
            if(s == sum)
                return true;
            else
                return false;
        }


        return helper(node.left, sum, s) || helper(node.right, sum, s);
    }
}
