import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MinimumHeightTree {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            return result;
        }
        
        if (n == 1) {
            result.add(0);
            return result;
        }
        
        List<Set<Integer>> list = new ArrayList<Set<Integer>>();
        for (int i =0; i < n; i++) {
            list.add(new HashSet<Integer>());
        }
        
        for (int[] edge: edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (list.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        if (leaves.size() == 0) {
            return result;
        }
        
        while (n > 2) {
            n = n - leaves.size();
            
            List<Integer> newLeaves = new LinkedList<Integer>();
            
            for (Integer leaf : leaves) {
                Integer neighbor = list.get(leaf).iterator().next();
                list.get(neighbor).remove(leaf);
                if (list.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            
            leaves = newLeaves;
        }
        
        return leaves;
    }
}
