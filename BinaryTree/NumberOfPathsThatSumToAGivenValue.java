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

    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        traverse(root, sum);
        return count;
    }

   void traverse(TreeNode root, int sum){
       if(root == null)
           return;

       helper(root, sum, 0);

       pathSum(root.left, sum);
       pathSum(root.right, sum);
   }

    void helper(TreeNode node, int sum, int s){

        if(node == null)
            return;

        s += node.val;

            if(s == sum){
                count++;
            }


        helper(node.left, sum, s);
        helper(node.right, sum, s);

    }
}
