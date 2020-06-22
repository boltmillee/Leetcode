/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        List<Integer> inorder = new ArrayList();

        for(int i=0; i<preorder.length; i++)
            inorder.add(preorder[i]);
        Collections.sort(inorder);
        return helper(preorder, inorder, 0, preorder.length);
    }

    TreeNode helper(int[] pre, List<Integer> in, Integer left, Integer right){

        if(left==right)
            return null;


        TreeNode t = new TreeNode(pre[index]);
        Integer ind = in.indexOf(t.val);

        System.out.println(ind);
        index++;

        t.left = helper(pre, in, left, ind);
        t.right = helper(pre, in, ind+1, right);

        return t;
    }
}
