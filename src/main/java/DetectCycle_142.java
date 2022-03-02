import java.util.HashSet;
import java.util.Set;


public class DetectCycle_142 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode detectCycleHashSet(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while(head!=null) {
            if(set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=slow) {
            if(fast==null || fast.next==null) return null;
            fast = fast.next.next;
            if(slow==null) return null;
            slow = slow.next;
        }
        ListNode ptr = head;
        while(ptr != slow) {
            ptr=ptr.next;
            slow = slow.next;
        }
        return ptr;
    }
}
