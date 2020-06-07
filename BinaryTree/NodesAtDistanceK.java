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

    List<Integer> list = new ArrayList();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        helper(root, target, K);

        return list;
    }

    int helper(TreeNode root, TreeNode target, int k){

        if(root == null || target == null || k<0)
            return -1;

        if(root == target){
            KdistanceChildren(target, k);
            return 0;
        }

        int left = helper(root.left, target, k);

        if(left != -1){
            if(left+1 == k){
                list.add(root.val);
            } else{
                KdistanceChildren(root.right, k-2-left);
            }

            return left +1;
        }

        int right = helper(root.right, target, k);

        if(right != -1){
            if(right+1 == k){
                list.add(root.val);
            } else{
                KdistanceChildren(root.left, k-2-right);
            }

            return right +1;
        }

        return -1;

    }

    void KdistanceChildren(TreeNode n, int k){
        if(n == null)
            return;

        if(k==0)
            list.add(n.val);

        KdistanceChildren(n.left, k-1);
        KdistanceChildren(n.right, k-1);
    }
}
