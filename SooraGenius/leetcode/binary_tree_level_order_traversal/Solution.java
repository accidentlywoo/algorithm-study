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
	private List<List<Integer>> results;
	public List<List<Integer>> levelOrder(TreeNode root) {
		int maxDepth = getMaxDepth(root, 0);

		results = new ArrayList();
		for(int i = 0; i<maxDepth; i++) {
			results.add(new ArrayList());
		}

		addValue(root, 0);
		return results;
	}
	public int getMaxDepth(TreeNode root, int cnt) {
		if(root == null) return cnt;
		return Integer.max(getMaxDepth(root.left, cnt + 1), getMaxDepth(root.right, cnt + 1));
	}
	public void addValue(TreeNode root, int level) {
		if(root == null) return;
		results.get(level).add(root.val);
		addValue(root.left, level + 1);
		addValue(root.right, level + 1);
	}
}