
public class GraphValidTree {

	public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < n; i++) {
            list.add(i, new ArrayList<Integer>());
        }
        
        for (int[] edge: edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            
            if (visited[vertex]) {
                return false;
            }
            
            visited[vertex] = true;
            for(int i : list.get(vertex)) {
                if (!visited[i]) {
                    queue.offer(i);
                }
            }
        }
        
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        
        return true;
    }
}
