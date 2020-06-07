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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> list = new ArrayList();

        if(root== null)
            return list;

        if(root.left == null && root.right == null){
            list.add(root.val);
            return list;
        }

        Stack<Integer> stack = new Stack();
        TreeNode temp =null, temp2=null;

        //adding left boundary
        list.add(root.val);
        if(root.left != null){
            temp = root.left;
            while(temp != null){

            if(temp.left == null && temp.right == null)
                break;
            list.add(temp.val);

            if(temp.left != null)
                temp = temp.left;
            else
                temp = temp.right;
        }
        }


        helper(root, list);

        //adding right boundary
        if(root.right != null){
            temp2 = root.right;
          while(temp2!= null){

            if(temp2.right == null && temp2.left == null)
                 break;
            stack.push(temp2.val);

            if(temp2.right != null)
                temp2 = temp2.right;
            else
                temp2 = temp2.left;
        }
        }

        while(stack.size()>0){
            list.add(stack.pop());
        }

        return list;
    }

    //for adding leaf nodes
    void helper(TreeNode node, List<Integer> list){
        if(node == null)
            return;

        if(node.left == null && node.right == null){
           list.add(node.val);
        }

        helper(node.left, list);
        helper(node.right, list);
    }
}
