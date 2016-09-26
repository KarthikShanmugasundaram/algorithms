import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        
        
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        current.add(root);
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        while (!current.isEmpty()) {
            TreeNode node = current.peek();
            current.remove(node);
            list.add(node.val);
            
            if (node.left != null) {
                next.add(node.left);
            }
            
            if (node.right != null) {
                next.add(node.right);
            }
            
            if (current.isEmpty()) {
                current = next;
                next = new LinkedList<TreeNode>();
                
                result.add(list);
                list = new ArrayList<Integer>();
            }
        }
        
        return result;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}