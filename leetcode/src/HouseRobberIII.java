
public class HouseRobberIII {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] result = getMax(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] getMax(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            return result;
        }
        
        int[] left = getMax(root.left);
        int[] right = getMax(root.right);
        
        result[0] = root.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return result;
    }
}
