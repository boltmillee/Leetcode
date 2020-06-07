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
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null)
            return new ArrayList();

        List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode t = q.poll();

            if(t == null){
                //List<Integer> cloned_list = new ArrayList<Integer>(list);
                result.add(list);
                list = new ArrayList();
                if(q.isEmpty())
                    break;
                 q.add(null);
                continue;
            }

            list.add(t.val);

            if(t.left != null)
                q.add(t.left);

            if(t.right != null)
                q.add(t.right);

        }

        return result;
    }
}
