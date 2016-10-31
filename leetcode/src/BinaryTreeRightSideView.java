import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode node, List<Integer> result) {
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        queue1.add(node);
        
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
      
            TreeNode temp = null;      
            while (!queue1.isEmpty()) {
                temp = queue1.poll();
                if (temp.left != null) {
                    queue2.add(temp.left);                
                }
                if (temp.right != null) {
                    queue2.add(temp.right);
                }
            }
            
            if (temp != null) {
                result.add(temp.val);
                continue;
            }
                
            while(!queue2.isEmpty()) {
                temp = queue2.poll();
                if (temp.left != null) {
                    queue1.add(temp.left);                
                }
                if (temp.right != null) {
                    queue1.add(temp.right);
                }
                
            }
            
            if (temp != null) {
                result.add(temp.val);
                continue;
            }
        }
    }
}
