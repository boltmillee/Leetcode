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
    public int widthOfBinaryTree(TreeNode root) {

        List<Integer> distList = new ArrayList<>();
        width(root, 0, distList);
        for(Integer a: distList){
            //System.out.println(a);
        }
        int max = Collections.max(distList);
        int min = Collections.min(distList);
        return max-min;
    }

    private void width(TreeNode node, int distance, List<Integer> distList){

        if(node == null)
            return;

        distList.add(distance);

        width(node.left, distance-1, distList);
        width(node.right, distance +1, distList);
    }
}
