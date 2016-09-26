import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            
            if (node.next != null) {
                queue.add(node.next);
            }
            p = p.next;
        }
        
        return head.next;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

