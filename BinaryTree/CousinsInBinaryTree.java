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
    int x_depth=Integer.MAX_VALUE; int y_depth=Integer.MAX_VALUE;
    public boolean isCousins(TreeNode root, int x, int y) {

        return helper(root, x, y, 0);
    }

    boolean helper(TreeNode root, int x, int y, int depth){

        if(root == null)
            return false;

        if(root.left != null && root.right != null){
            if(root.left.val == x || root.right.val == x){
               if(root.left.val == x && root.right.val == y)
                   return false;

                if(root.left.val == y && root.right.val == x)
                    return false;
        }

        if(root.left.val == y || root.right.val == y){
               if(root.left.val == x && root.right.val == y)
                   return false;

                if(root.left.val == y && root.right.val == x)
                    return false;
        }
        }

        if(root.val == x)
            x_depth = depth;

        if(root.val == y)
            y_depth = depth;

        if(x_depth != Integer.MAX_VALUE && y_depth != Integer.MAX_VALUE && x_depth == y_depth)
            return true;

        depth = depth +1;
        boolean left = helper(root.left, x, y, depth);
        boolean right = helper(root.right, x, y, depth);

        return left || right;

    }
}
