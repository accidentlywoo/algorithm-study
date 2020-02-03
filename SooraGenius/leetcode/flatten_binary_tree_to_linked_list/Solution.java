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
    public void flatten(TreeNode root) {
        if(root != null) {
            List<Integer> list = new ArrayList<>();
            call(root, list);
            root.left = null;
            root.right = null;
            for(int i = 1; i<list.size(); i++) {
                root.right = new TreeNode(list.get(i));
                root = root.right;
            }
        }
    }
    public void call(TreeNode root, List<Integer> list) {
        if(root != null) {
            list.add(root.val);
            call(root.left, list);
            call(root.right, list);
        }
    }
}