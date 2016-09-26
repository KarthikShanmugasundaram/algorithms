import java.util.PriorityQueue;

public class KthLargetElement {

	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        
        for (int number: nums) {
            queue.offer(number);

            if (queue.size() > k ) {
                queue.poll();
            }
        }
        
        return queue.poll();
    }
}
