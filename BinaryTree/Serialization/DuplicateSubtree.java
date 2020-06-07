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
//https://leetcode.com/problems/find-duplicate-subtrees/
class Solution {

    //List<TreeNode> list = new ArrayList();
    //Set<TreeNode> set = new HashSet();
    Map<String, Integer> map = new HashMap();
    List<TreeNode> list = new ArrayList();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // if(root== null)
        //     return list;
        // Map<Integer, List<TreeNode>> map = new HashMap();
        // helper(root, map);
        // list.addAll(set);
        // return list;
        StringBuilder sb = new StringBuilder();
        preOrderWithSerialize(root);
        System.out.print(sb.toString());
        return list;
    }

    String preOrderWithSerialize(TreeNode node){

        //StringBuilder sb = new StringBuilder();
        if(node == null){

            return "x";
        }

        String resultant = node.val + " "+preOrderWithSerialize(node.left) + " "+ preOrderWithSerialize(node.right);
        //System.out.println(resultant);
        //sb = sb.append(node.val);
        map.put(resultant, map.getOrDefault(resultant, 0) + 1);

        if(map.get(resultant) == 2)
            list.add(node);

        return resultant;
    }

//     void helper(TreeNode node, Map<Integer, List<TreeNode>> map){
//         if(node == null)
//             return;

//         if(map.get(node.val) != null){
//             boolean found = false;
//             List<TreeNode> temp = new ArrayList();
//             for(TreeNode t : map.get(node.val)){
//                 boolean equal = isEqual(node, t);
//                 if(equal){

//                     for(TreeNode tt : set){
//                         boolean setEqual = isEqual(node, tt);
//                         if(setEqual){
//                             found = true;
//                             break;
//                         }

//                     }

//                     if(!found){
//                         set.add(node);
//                         //map.get(node.val).add(node);
//                     }


//                     break;
//                 }else{
//                    //map.get(node.val).add(node);
//                 }
//             }

//             if(!found)
//                 map.get(node.val).add(node);
//         } else{
//             List<TreeNode> nodeList = new ArrayList();
//             nodeList.add(node);
//             map.put(node.val, nodeList);
//         }

//         helper(node.left, map);
//         helper(node.right, map);
//     }

//     boolean isEqual(TreeNode a, TreeNode b){
//         if(a == null && b == null)
//             return true;

//         if(a == null && b != null || b == null && a != null)
//             return false;

//         return a.val == b.val && isEqual(a.left, b.left) && isEqual(a.right, b.right);
//     }
}
