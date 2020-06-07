/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/submissions/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        shelper(root, sb);
        return sb.toString();
    }

    void shelper(TreeNode t, StringBuilder sb){
        if(t == null){
            sb.append("x ");
            return;
        }

        sb.append(t.val + " ");
        shelper(t.left, sb);
        shelper(t.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.print(data);
        int[] arr = new int[1];
        String[] str = data.split(" ");
        return dhelper(str, arr);
    }

    TreeNode dhelper(String[] str, int[] arr){
        if(str[arr[0]].equals("x")){
            arr[0]++;
            return null;
        }

        TreeNode t = new TreeNode(Integer.parseInt(str[arr[0]]));
        arr[0]++;
        t.left = dhelper(str, arr);
        t.right = dhelper(str, arr);

        return t;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
