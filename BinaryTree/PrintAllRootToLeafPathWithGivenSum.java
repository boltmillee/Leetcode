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
     List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<Integer> list = new ArrayList();
        helper(root, sum, 0, list);

        return result;
    }

    boolean helper(TreeNode node, int sum, int s, List<Integer> list){

        if(node == null){
             list.add(null);
             return false;
        }

        list.add(node.val);

        s += node.val;
        if(node.right == null && node.left == null){
            if(s == sum){
                List<Integer> cloneList = new ArrayList<Integer>(list);
                result.add(cloneList);
                return true;
            }else
                return false;
        }

        boolean left = helper(node.left, sum, s, list);
        if(list.size() > 1)
            list.remove(list.size()-1);
        boolean right = helper(node.right, sum, s, list);
        if(list.size() > 1)
            list.remove(list.size()-1);



        return left || right;
    }
}
