
public class LeftSumOfTree {

	public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 0;
        }
        
        return search(root, false);
    }
    
    private int search (TreeNode node, boolean left) {
        if (node.left == null && node.right == null) {
            if (left) {
                return node.val;
            } else {
                return 0;
            }
        }
        
        int count = 0;
        if (node.left != null) {
            count += search(node.left, true);
        }
        
        if (node.right != null) {
            count += search(node.right, false);
        }
        
        return count;
    }
}
