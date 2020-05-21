/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Question
 //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/submissions/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList();
        StringBuilder str = new StringBuilder();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode t = q.poll();

            if(t == null){
                str.append("x ");
                continue;
            }

            str.append(t.val + " ");

            q.add(t.left);
            q.add(t.right);
        }

        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if(data.length() == 0) return null;

        String[] arr = data.split(" ");
        Queue<TreeNode> q = new LinkedList();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        for(int i =1; i<arr.length; i++){
            //int val = Integer.parseInt(arr[i]);
            TreeNode t = q.poll();
            if(!arr[i].equals("x")){
                t.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(t.left);
            }

            if(!arr[++i].equals("x")){
                t.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(t.right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
