
public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        
        if (height(node) < 0) {
            return false;
        }
        
        return true;
    }
    
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = height(node.left);
        if (left < 0) {
            return left;
        }
        int right = height(node.right);
        if (right < 0) {
            return right;
        }
        
        if ((left - right) > 1 || (right - left) > 1) {
            return -1;
        }
        
        return 1 + Math.max(left, right);
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
