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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();

        if(root == null)
            return result;
        Stack<TreeNode> q1 = new Stack();
        Stack<TreeNode> q2 = new Stack();
        boolean isReverse = false;
        q1.add(root);
        //q1.add(null);

        while(q1.size()>0 || q2.size()>0){
            List<Integer> l = new ArrayList();

            while(!q1.isEmpty()){
                TreeNode t = q1.pop();
                l.add(t.val);


                if(t.left != null)
                    q2.push(t.left);

                if(t.right != null)
                    q2.push(t.right);

            }

            // if(isReverse){
            //     Collections.reverse(l);
            //     isReverse = false;
            // } else {
            //     isReverse = true;
            // }
            if(!l.isEmpty())
                result.add(l);

            List<Integer> r = new ArrayList();

            while(!q2.isEmpty()){
             TreeNode n = q2.pop();
                r.add(n.val);


                if(n.right != null)
                    q1.push(n.right);

                if(n.left != null)
                    q1.push(n.left);

            }

            // if(isReverse){
            //     Collections.reverse(r);
            //     isReverse = false;
            // } else {
            //     isReverse = true;
            // }
            if(!r.isEmpty())
                result.add(r);
        }

        return result;
    }
}
