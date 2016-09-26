
public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        
        System.out.println("Value: " + root.val + " find: " + p.val);

        if (root.val == p.val) {
            
            if (root.right != null) {
                TreeNode succ = root.right;
                while (succ.left != null) {
                    succ = succ.left;
                }
            
                return succ;
            }
        }
        
        TreeNode succ = null;
        if (root.val > p.val && root.left != null) {
            succ = root;
            TreeNode temp = inorderSuccessor(root.left, p);
            if (temp != null) {
                succ = temp;
            }
        } else if (root.right != null) {
            TreeNode temp = inorderSuccessor(root.right, p);
            if (temp != null) {
                succ = temp;
            }
        }
        
        return succ;
    }

}
