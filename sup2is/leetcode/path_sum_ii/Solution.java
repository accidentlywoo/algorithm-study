package path_sum_ii;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if(root == null) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        dfs(root, sum - root.val, list);

        return result;
    }

    private void dfs(TreeNode node, int sum, List<Integer> list) {
        if(node.left == null && node.right == null && sum == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if(node.left != null) {
            list.add(node.left.val);
            dfs(node.left, sum - node.left.val, list);
            list.remove(list.size() - 1);
        }

        if(node.right != null) {
            list.add(node.right.val);
            dfs(node.right, sum - node.right.val, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Solution solution = new Solution();
        System.out.println(solution.pathSum(root, 22));
    }


}
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
