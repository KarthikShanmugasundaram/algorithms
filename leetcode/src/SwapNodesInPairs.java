
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        head = p2;

        ListNode prev = null;
        while (p1 != null && p2 != null) {
            if (prev != null) {
                prev.next = p2;
            }
            p1.next = p2.next;
            p2.next = p1;
            
            prev = p1;
            p1 = p1.next;
 
            if (p1 != null) {
                p2 = p1.next;
            }
                
        }
        
        return head;
    }
}
