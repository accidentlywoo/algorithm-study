package flatten_binary_tree_to_linked_list;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<Integer> list = new LinkedList<>();
        preOrder(root, list);

        root.left = null;
        createFlattenTree(root, list);
    }

    private void preOrder(TreeNode node, Queue<Integer> list) {

        if(node.left != null) {
            list.add(node.left.val);
            preOrder(node.left, list);
        }

        if(node.right != null) {
            list.add(node.right.val);
            preOrder(node.right, list);
        }
    }

    private void createFlattenTree(TreeNode node, Queue<Integer> list) {
        if(list.isEmpty()) {
            return;
        }else {
            node.right = new TreeNode(list.poll());
            createFlattenTree(node.right, list);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        solution.flatten(root);
        System.out.println();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
    }
}