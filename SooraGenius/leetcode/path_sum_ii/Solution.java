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
    List<List<Integer>> result = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        List<Integer> list = new ArrayList<>();
        if(root != null) {
            list.add(root.val);
            call(root, root.val, list);
        }
        return result;
    }
    public void call(TreeNode root, int totSum, List<Integer> list) {
        //System.out.println(sum);
        if(totSum == sum && root.left == null && root.right == null) {
            result.add(new ArrayList(list));
        }
        if(root.left != null) {
            list.add(root.left.val);
            call(root.left, totSum + root.left.val, list);
            list.remove(list.size() - 1);
        }
        if(root.right != null) {
            list.add(root.right.val);
            call(root.right, totSum + root.right.val, list);
            list.remove(list.size() - 1);
        }
    }
}