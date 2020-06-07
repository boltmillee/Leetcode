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
    boolean result = false;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s== null && t != null)
            return false;

        helper(s, t);
        return result;
    }

    void helper(TreeNode s, TreeNode t){
        if(s== null)
            return;

        if(s.val == t.val){
            //System.out.println(s.val + " " + t.val);
            boolean equal = isEqual(s, t);
            result = result || equal;
            if(result)
                return;
        }

        helper(s.left, t);
        helper(s.right, t);
    }

    boolean isEqual(TreeNode a, TreeNode b){
        if(a == null && b == null)
            return true;

        if(a == null && b != null || b == null && a != null)
            return false;

        return a.val == b.val && isEqual(a.left, b.left) && isEqual(a.right, b.right);
    }
}
