
public class MaximumDepthBinaryTree {

	public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        } 
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        if (leftDepth < rightDepth) {
            return rightDepth + 1;
        } else {
            return leftDepth + 1;
        }
    }
}
