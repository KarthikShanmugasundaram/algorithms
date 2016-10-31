import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinaryTreeVerticalOrderTraversal {

	public List<List<Integer>> verticalOrder(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if(root==null)
	        return result;
	 
	    // level and list    
	    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	 
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	    LinkedList<Integer> level = new LinkedList<Integer>();
	 
	    queue.offer(root);
	    level.offer(0);
	 
	    int minLevel=0;
	    int maxLevel=0;
	 
	    while(!queue.isEmpty()){
	        TreeNode p = queue.poll();
	        int l = level.poll();
	 
	        minLevel=Math.min(minLevel, l);
	        maxLevel=Math.max(maxLevel, l);
	 
	        if(map.containsKey(l)){
	            map.get(l).add(p.val);
	        }else{
	            List<Integer> list = new ArrayList<Integer>();
	            list.add(p.val);
	            map.put(l, list);
	        }
	 
	        if(p.left!=null){
	            queue.offer(p.left);
	            level.offer(l-1);
	        }
	 
	        if(p.right!=null){
	            queue.offer(p.right);
	            level.offer(l+1);
	        }
	    }
	 
	 
	    for(int i=minLevel; i<=maxLevel; i++){
	        if(map.containsKey(i)){
	            result.add(map.get(i));
	        }
	    }
	 
	    return result;
	}
}
